package com.valeriamprodrigues.notes.ui.addNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import com.valeriamprodrigues.notes.data.COLLECTION_NOTES
import com.valeriamprodrigues.notes.data.NOTE_KEY
import com.valeriamprodrigues.notes.databinding.FragmentAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class  AddNoteFragment : BottomSheetDialogFragment() {
    private val viewModel: AddNoteViewModel by viewModels()
    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        setObserve()
    }

    private fun setListener() {
        binding.btnAddNoteAdd.setOnClickListener {
            val description = binding.etAddNoteDescription.text.toString()
            val title = binding.etAddNoteTitle.text.toString()
            viewModel.createNote(title, description)
        }
    }

    private fun setObserve() {
        viewModel.titleError.observe(viewLifecycleOwner) {
            binding.tilAddNoteTitle.setTextError(it)
        }
        viewModel.descriptionError.observe(viewLifecycleOwner) {
            binding.tilAddNoteDescription.setTextError(it)
        }
        viewModel.noteCreated.observe(viewLifecycleOwner) { note ->
            findNavController().run {
                previousBackStackEntry?.savedStateHandle?.set(NOTE_KEY, note)
                popBackStack()
            }
        }
    }

    private fun TextInputLayout.setTextError(string: Int?) {
        error = if (string != null) {
            getString(string)
        } else null
    }
}