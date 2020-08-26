package com.example.notes.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.notes.listener.NoteInteractionListener
import com.example.notes.model.Note

class Utils{

    companion object{
        fun showNoteUpdateDialog(
            context: Context,
            notesInteractionListener: NoteInteractionListener,
            note: Note
        ){

            val items = arrayOf<CharSequence>("Update", "Delete")
            val dialog = AlertDialog.Builder(context).setItems(items
            ) { dialog, which ->
                if (which == 0){
                    notesInteractionListener.updateNote(note)
                } else{
                    notesInteractionListener.deleteNote(note)
                }
            }
            dialog.show()
        }
    }
}