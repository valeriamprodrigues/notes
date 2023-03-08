package com.valeriamprodrigues.notes.data

import com.valeriamprodrigues.notes.domain.model.Note

class NoteRepository(private val dataSource: NoteDataSource) {
    suspend fun createNote(note: Note): Note = dataSource.createNote(note)
    suspend fun getNotes(): List<Note> = dataSource.getNotes()
}