package com.valeriamprodrigues.notes.data.di

import com.valeriamprodrigues.notes.data.FirebaseNoteDataSource
import com.valeriamprodrigues.notes.data.NoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindNoteDataSource(dataSource: FirebaseNoteDataSource): NoteDataSource
}