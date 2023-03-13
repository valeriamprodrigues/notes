package com.valeriamprodrigues.notes.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.valeriamprodrigues.notes.R
import com.valeriamprodrigues.notes.data.NOTE_KEY
import com.valeriamprodrigues.notes.databinding.FragmentNotesBinding
import com.valeriamprodrigues.notes.domain.model.Note
import com.valeriamprodrigues.notes.ui.addNote.AddNoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    private val notesAdapter = NotesAdapter()
    private val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycle()
        setListeners()
        observeNavBackStack()
        observeVMEvents()
        getNotes()
    }

    private fun observeVMEvents() {
        viewModel.notesData.observe(viewLifecycleOwner) {
            binding.swuipeNotes.isRefreshing = false
            notesAdapter.submitList(it)
        }
    }

    private fun setRecycle() {
        binding.rvFragmentNotes.run {
            adapter = notesAdapter
        }
    }

    private fun setListeners() {
        with(binding) {
            fabFragmentNotesAdd.setOnClickListener {
                findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment)
            }
            swuipeNotes.setOnRefreshListener {
                getNotes()
            }
        }
    }

    private fun getNotes() {
        viewModel.getNotes()
    }

    private fun observeNavBackStack(){
        findNavController().run {
            val navBackStackEntry = getBackStackEntry(R.id.notesFragment)
            val savedStateHandle = navBackStackEntry.savedStateHandle
            val observer = LifecycleEventObserver{_, event ->
                if(event == Lifecycle.Event.ON_RESUME && savedStateHandle.contains(NOTE_KEY)) {
                    val note = savedStateHandle.get<Note>(NOTE_KEY)
                    val newList = notesAdapter.currentList.toMutableList().apply {
                        add(note)
                    }
                    notesAdapter.submitList(newList)
                    binding.rvFragmentNotes.smoothScrollToPosition(newList.size-1)
                    savedStateHandle.remove<Note>(NOTE_KEY )
                }
            }
            navBackStackEntry.lifecycle.addObserver(observer)
            viewLifecycleOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_DESTROY)
                    navBackStackEntry.lifecycle.removeObserver(observer)

            })
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}