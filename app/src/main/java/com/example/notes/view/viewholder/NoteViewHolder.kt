package com.example.notes.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.ListItemNoteBinding
import com.example.notes.listener.NoteInteractionListener
import com.example.notes.model.Note
import com.example.notes.util.Utils

class NoteViewHolder(val binding:ListItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    lateinit var notesInteractionListener: NoteInteractionListener
    lateinit var note:Note

    fun bind(note: Note) {
        binding.note = note
        this.note = note
        binding.holder = this
        binding.executePendingBindings()
    }

    fun onItemClicked(){
        Utils.showNoteUpdateDialog(binding.root.context, notesInteractionListener, note);
    }

}