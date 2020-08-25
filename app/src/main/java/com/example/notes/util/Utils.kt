package com.example.notes.util

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Utils{

    companion object{
        fun showNoteUpdateDialog( context:Context){

            val items = arrayOf<CharSequence>("Update", "Delete")
            val dialog = AlertDialog.Builder(context).setItems(items
            ) { dialog, which ->
                Toast.makeText(context, items[which], Toast.LENGTH_LONG).show()

            }
            dialog.show()
        }
    }
}