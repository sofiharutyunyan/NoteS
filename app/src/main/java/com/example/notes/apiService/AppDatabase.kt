package com.example.notes.apiService

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.model.Note
import com.example.notes.util.Constants

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {
        private var noteDB: AppDatabase? = null

        fun  /*synchronized*/getInstance(context: Context?): AppDatabase? {
            if (null == noteDB) {
                noteDB = context?.let { buildDatabaseInstance(it) }
            }
            return noteDB
        }

        private fun buildDatabaseInstance(context: Context): AppDatabase? {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                Constants.DB_NAME
            ).allowMainThreadQueries().build()
        }
    }

    open fun cleanUp() {
        noteDB = null
    }
}