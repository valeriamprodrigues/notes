package com.valeriamprodrigues.notes.ui.addNote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valeriamprodrigues.notes.R
import com.valeriamprodrigues.notes.domain.model.Note
import com.valeriamprodrigues.notes.domain.usecase.CreateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase
) : ViewModel() {
    private val _titleError = MutableLiveData<Int?>()
    val titleError: LiveData<Int?> = _titleError
    private val _descriptionError = MutableLiveData<Int?>()
    val descriptionError: LiveData<Int?> = _descriptionError

    private val _noteCreated = MutableLiveData<Note>()
    val noteCreated: LiveData<Note> = _noteCreated

    private var isFormValid = false
    fun createNote(title: String, description: String) = viewModelScope.launch {
        isFormValid = true
        _titleError.value = getErrorTitleIsEmpty(title)
        _descriptionError.value = getErrorDescriptionIsEmpty(description)
        if (isFormValid) {
            try {
                val note = createNoteUseCase(title = title, description = description)
                _noteCreated.value = note

            } catch (e: Exception) {
                Log.d("Erro:", e.toString())
            }
        }
    }
    private fun getErrorTitleIsEmpty(value: String):Int? {
        return if (value.isNullOrEmpty()) {
            isFormValid = false
            R.string.add_note_title_error
        } else
            null
    }
    private fun getErrorDescriptionIsEmpty(value: String):Int? {
        return if (value.isNullOrEmpty()) {
            isFormValid = false
            R.string.add_note_description_error
        } else
            null
    }
}