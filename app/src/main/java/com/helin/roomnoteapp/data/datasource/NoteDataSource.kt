package com.helin.roomnoteapp.data.datasource

import android.annotation.SuppressLint
import com.helin.roomnoteapp.data.entity.Note
import com.helin.roomnoteapp.room.NoteDao
import com.helin.roomnoteapp.util.getCurrentDateFormatted
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class NoteDataSource (var noteDao: NoteDao){

    @SuppressLint("SuspiciousIndentation")
    suspend fun kayit(note_title : String, note_desc: String ) {
        val yeniNote = Note(0,note_title,note_desc)
            noteDao.kayit(yeniNote)
        }

    suspend fun guncelle(note_id : Int , note_title : String , note_desc : String) =
        withContext(Dispatchers.IO){
            val currentDate = Date().getCurrentDateFormatted()
            val guncellenenNote = Note(note_id , note_title , note_desc)
            noteDao.update(guncellenenNote)
        }

    suspend fun ara(aramaKelimesi : String) : List<Note> =
        withContext(Dispatchers.IO){
            return@withContext noteDao.ara(aramaKelimesi)
        }

    suspend fun noteYukle() : List<Note> =
        withContext(Dispatchers.IO){
            return@withContext noteDao.uploadNotes()
        }

    suspend fun sil(note_id: Int) {
        val silinenNote = Note(note_id,"","")
        noteDao.delete(silinenNote)

    }

}