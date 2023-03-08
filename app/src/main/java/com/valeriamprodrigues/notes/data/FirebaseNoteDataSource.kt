package com.valeriamprodrigues.notes.data

import com.google.firebase.firestore.FirebaseFirestore
import com.valeriamprodrigues.notes.BuildConfig
import com.valeriamprodrigues.notes.domain.model.Note
import com.valeriamprodrigues.notes.util.COLLECTION_ROOT
import kotlin.coroutines.suspendCoroutine

class FirebaseNoteDataSource(
    firebaseFirestore: FirebaseFirestore
): NoteDataSource {

    //data/idea/notes/timestamp/itens
    private val documentReference =
        firebaseFirestore.document("$COLLECTION_ROOT/${BuildConfig.FIREBASE_FLAVOR_COLLECTION}}")

    override suspend fun createNote(note: Note): Note {
        return suspendCoroutine { continuation ->
            documentReference
                .collection(COLLECTION_NOTES)
                .document(System.currentTimeMillis().toString())
                .set(note)
                .addOnSuccessListener {
                    continuation.resumeWith(Result.success(note))
                }
                .addOnFailureListener {
                    continuation.resumeWith(Result.failure(it))
                }
        }
    }

    override suspend fun getNotes(): List<Note> {
        return suspendCoroutine { continuation ->
            val notesReference = documentReference.collection(COLLECTION_NOTES)
            notesReference.get().addOnSuccessListener { documents ->
                val notes = mutableListOf<Note>()
                for (document in documents) {
                    document.toObject(Note::class.java).run {
                        notes.add(this)
                    }
                }
                continuation.resumeWith(Result.success(notes))
            }
            notesReference.get().addOnFailureListener() {
                continuation.resumeWith(Result.failure(it))
            }
        }
    }
}

