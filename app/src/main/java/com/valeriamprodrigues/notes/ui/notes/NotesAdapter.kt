package com.valeriamprodrigues.notes.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.valeriamprodrigues.notes.databinding.ItemNoteBinding
import com.valeriamprodrigues.notes.domain.model.Note

class NotesAdapter: ListAdapter<Note,NotesAdapter.NotesViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NotesViewHolder(
        private val itemBinding: ItemNoteBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(note: Note) {
            itemBinding.run {
                tvItemNoteTitle.text = note.title
                tvItemNoteDescription.text = note.text
            }
        }

        companion object {
            fun create(parent: ViewGroup): NotesViewHolder {
                val itemBinding =
                    ItemNoteBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return NotesViewHolder(itemBinding)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Note>() {

            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }

        }
    }
}