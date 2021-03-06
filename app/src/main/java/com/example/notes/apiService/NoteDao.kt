package com.example.notes.apiService

import androidx.room.*
import com.example.notes.model.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAll(): List<Note>
//
//    @Query("SELECT * FROM note WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<Note>
//
//    @Query("SELECT * FROM user WHERE title LIKE :title AND " +
//            "note_body LIKE :noteBody LIMIT 1")

//    fun findNote(title: String, noteBody: String): Note

    @Query("SELECT * FROM note WHERE uid = :key")
    fun get(key: Int): Note?

    @Delete
    fun delete(vararg note: Note?)

    @Update
    fun update(vararg note: Note?)

    @Insert
    fun insert(vararg note: Note?)
}