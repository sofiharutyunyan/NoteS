package com.example.notes.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.notes.R

class Utils{

    companion object{
        fun showNoteUpdateDialog( context:Context){
            AlertDialog.Builder(context)
                .setPositiveButton(R.string.update, null)
                .setNegativeButton(R.string.delete, null)
                .show()
        }
    }
}