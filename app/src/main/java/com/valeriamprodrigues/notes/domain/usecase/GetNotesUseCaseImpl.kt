package com.valeriamprodrigues.notes.domain.usecase

import com.valeriamprodrigues.notes.data.NoteRepository
import com.valeriamprodrigues.notes.domain.model.Note
import javax.inject.Inject

class GetNotesUseCaseImpl @Inject constructor(private val noteRepository: NoteRepository): GetNotesUseCase {
    override suspend  fun invoke(): List<Note>{
        return noteRepository.getNotes()
    }
}