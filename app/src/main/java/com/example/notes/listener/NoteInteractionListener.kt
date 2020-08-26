package com.example.notes.listener

import com.example.notes.model.Note

interface NoteInteractionListener {

    fun updateNote(note: Note)

    fun deleteNote(note:Note)
}