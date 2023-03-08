package com.valeriamprodrigues.notes.domain.usecase

import com.valeriamprodrigues.notes.domain.model.Note

interface GetNotesUseCaseImpl {
    suspend operator fun invoke(): List<Note>
}