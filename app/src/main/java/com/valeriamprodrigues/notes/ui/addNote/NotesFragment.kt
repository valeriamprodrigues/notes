package com.valeriamprodrigues.notes.ui.addNote

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.valeriamprodrigues.notes.R
import com.valeriamprodrigues.notes.databinding.FragmentAddNoteBinding
import com.valeriamprodrigues.notes.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {
    private lateinit var viewModel: AddNoteViewModel
    private var _binding : FragmentNotesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }


}