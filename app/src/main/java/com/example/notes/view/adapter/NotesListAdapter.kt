package com.example.notes.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.ListItemNoteBinding
import com.example.notes.model.Note
import com.example.notes.view.viewholder.NoteViewHolder

class NotesListAdapter(private var list: ArrayList<Note>)
    : RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemNoteBinding.inflate(inflater)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note: Note = list[position]
        holder.bind(note)
    }

    override fun getItemCount(): Int = list.size

}