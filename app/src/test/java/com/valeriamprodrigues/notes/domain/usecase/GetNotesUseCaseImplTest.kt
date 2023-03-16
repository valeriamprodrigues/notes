package com.valeriamprodrigues.notes.domain.usecase

import com.valeriamprodrigues.notes.data.NoteDataSource
import com.valeriamprodrigues.notes.data.NoteRepository
import com.valeriamprodrigues.notes.domain.model.Note
import junit.framework.TestCase
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import kotlinx.coroutines.runBlocking
import java.util.*

internal class GetNotesUseCaseImplTest {
    @Mock
    val  dataSource = Mockito.mock(NoteDataSource::class.java)
    val noteRepository = NoteRepository(dataSource)

    @Test
    fun `when making the call, it needs to return a list of notes`()= runBlocking {

        // given
        val noteList = arrayListOf(
            Note(UUID.randomUUID().toString(), "Note 1", "This is note 1"),
            Note(UUID.randomUUID().toString(), "Note 2", "This is note 2"),
            Note(UUID.randomUUID().toString(), "Note 3", "This is note 3")
        )

        // when
        Mockito.`when`(
            noteRepository.getNotes()
        ).thenReturn(noteList)

        val notes = noteRepository.getNotes()

        // then
        TestCase.assertEquals(notes, noteList)
    }
}