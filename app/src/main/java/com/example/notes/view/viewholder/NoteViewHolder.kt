package com.example.notes.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.ListItemNoteBinding
import com.example.notes.model.Note
import com.example.notes.util.Utils

class NoteViewHolder(val binding:ListItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(note: Note) {
        binding.note = note
        binding.holder = this
        binding.executePendingBindings()
    }

    fun onItemClicked(){
        Utils.showNoteUpdateDialog(binding.root.context);
    }

}