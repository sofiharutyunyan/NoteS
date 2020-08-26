package com.example.notes.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.databinding.ListItemNoteBinding
import com.example.notes.listener.NoteInteractionListener
import com.example.notes.model.Note
import com.example.notes.view.viewholder.NoteViewHolder

class NotesListAdapter(private var list: ArrayList<Note>, var notesInteractionListener: NoteInteractionListener)
    : RecyclerView.Adapter<NoteViewHolder>() {

     var position: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemNoteBinding.inflate(inflater)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note: Note = list[position]
        this.position = position
        holder.bind(note)
        holder.notesInteractionListener = notesInteractionListener
    }

    override fun getItemCount(): Int = list.size

    fun removeNote(note: Note) {
        list.remove(note)
        notifyDataSetChanged()
    }

}