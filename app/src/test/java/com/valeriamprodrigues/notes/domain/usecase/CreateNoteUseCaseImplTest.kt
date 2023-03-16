package com.valeriamprodrigues.notes.domain.usecase

import com.valeriamprodrigues.notes.data.NoteDataSource
import com.valeriamprodrigues.notes.data.NoteRepository
import com.valeriamprodrigues.notes.domain.model.Note
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.kotlin.any
import java.util.*

internal class CreateNoteUseCaseImplTest {

     @Mock
     val dataSource = Mockito.mock(NoteDataSource::class.java)
     val noteRepositoryMock = NoteRepository(dataSource)
     val createNoteUseCase = CreateNoteUseCaseImpl(noteRepositoryMock)

     @Test
     fun `when input is valid, then output should be correct`() = runBlocking {
         // given
         val note = Note(
             id = UUID.randomUUID().toString(),
             title = "Test title",
             text = "Test text"
         )
         // when
         Mockito.`when`(
             noteRepositoryMock.createNote(
                 any<Note>()
             )
         ).thenReturn(note)

         val createdNote = createNoteUseCase.invoke("Test title", "Test text")

         // then
         assertEquals(note, createdNote)
     }
 }