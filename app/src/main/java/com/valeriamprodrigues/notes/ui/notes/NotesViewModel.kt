package com.valeriamprodrigues.notes.ui.notes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valeriamprodrigues.notes.domain.model.Note
import com.valeriamprodrigues.notes.domain.usecase.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase
) : ViewModel()  {
    private val _notesData = MutableLiveData<List<Note>>()
    val notesData: LiveData<List<Note>> = _notesData

    fun getNotes() = viewModelScope.launch {
        try{
            val notes = getNotesUseCase()
            _notesData.value =notes
        }catch(e: Exception) {
            Log.d("otesViewModel:", e.toString())
        }
    }
}