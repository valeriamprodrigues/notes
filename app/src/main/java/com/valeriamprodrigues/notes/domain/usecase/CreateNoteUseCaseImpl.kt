package com.valeriamprodrigues.notes.domain.usecase

import com.valeriamprodrigues.notes.data.NoteRepository
import com.valeriamprodrigues.notes.domain.model.Note
import java.lang.Exception
import java.util.*
import javax.inject.Inject

class CreateNoteUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
    ) : CreateNoteUseCase {
    override suspend fun invoke(title: String, text: String): Note {
        return try {
            repository.createNote(
                Note(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    text = text
                )
            )
        } catch (e: Exception) {
            throw e
        }
    }
}