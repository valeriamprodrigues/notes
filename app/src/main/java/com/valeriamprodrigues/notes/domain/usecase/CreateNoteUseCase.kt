package com.valeriamprodrigues.notes.domain.usecase

import com.valeriamprodrigues.notes.domain.model.Note

interface CreateNoteUseCase {
    suspend operator fun invoke(title: String, text: String): Note
}