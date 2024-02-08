package com.helin.roomnoteapp.room

import androidx.room.RoomDatabase
import androidx.room.Database
import com.helin.roomnoteapp.data.entity.Note

@Database(entities = [Note :: class] , version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getNotesDao() : NoteDao

}