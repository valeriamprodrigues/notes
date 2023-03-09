package com.valeriamprodrigues.notes.domain.usecase.di

import com.valeriamprodrigues.notes.domain.usecase.CreateNoteUseCase
import com.valeriamprodrigues.notes.domain.usecase.CreateNoteUseCaseImpl
import com.valeriamprodrigues.notes.domain.usecase.GetNotesUseCase
import com.valeriamprodrigues.notes.domain.usecase.GetNotesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {
    @Binds
    fun bindCreateNoteUseCase(useCase: CreateNoteUseCaseImpl): CreateNoteUseCase
    
    @Binds
    fun bindGetNotes(useCase: GetNotesUseCaseImpl): GetNotesUseCase

}