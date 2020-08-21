package com.example.notes.apiService

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.notes.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Note>

    @Query("SELECT * FROM user WHERE title LIKE :title AND " +
            "note_body LIKE :noteBody LIMIT 1")
    fun findNote(title: String, noteBody: String): Note

    @Insert
    fun insertAll(vararg users: Note)

    @Delete
    fun delete(note: Note)
}