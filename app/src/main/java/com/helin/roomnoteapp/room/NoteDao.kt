package com.helin.roomnoteapp.room

import androidx.room.*
import com.helin.roomnoteapp.data.entity.Note

@Dao
interface NoteDao  {

    @Query("SELECT * FROM notes")
    suspend fun uploadNotes() : List<Note>

    @Insert
    suspend fun kayit(note: Note)

    @Update
    suspend fun update(note: Note)

    @Query("SELECT * FROM notes WHERE note_desc LIKE '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi : String) : List<Note>

    @Delete
    suspend fun delete(note: Note)

}