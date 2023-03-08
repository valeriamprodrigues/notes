package com.valeriamprodrigues.notes.data

import com.valeriamprodrigues.notes.domain.model.Note

interface NoteDataSource {

    suspend fun createNote(note: Note): Note

    suspend fun getNotes(): List<Note>

}