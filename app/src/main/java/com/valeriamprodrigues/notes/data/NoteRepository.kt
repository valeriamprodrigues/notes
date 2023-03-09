package com.valeriamprodrigues.notes.data

import com.valeriamprodrigues.notes.domain.model.Note
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val dataSource: NoteDataSource
    ) {
    suspend fun createNote(note: Note): Note = dataSource.createNote(note)
    suspend fun getNotes(): List<Note> = dataSource.getNotes()
}