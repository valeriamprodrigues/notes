package com.valeriamprodrigues.notes.domain.usecase

import com.valeriamprodrigues.notes.domain.model.Note

interface GetNotesUseCase {
    suspend operator fun invoke(): List<Note>
}