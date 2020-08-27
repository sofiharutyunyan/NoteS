package com.example.notes.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AlertDialog
import com.example.notes.R
import com.example.notes.listener.NoteInteractionListener
import com.example.notes.model.Note

class Utils{

    companion object{
        fun showNoteUpdateDialog(
            context: Context,
            notesInteractionListener: NoteInteractionListener,
            note: Note
        ){

            val items = arrayOf<CharSequence>(context.getString(R.string.update), context.getString(R.string.delete))
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

        fun hideKeyboard(context: Context?, currentFocus: View?){
            val inputManager: InputMethodManager =
                context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
        }
    }
}