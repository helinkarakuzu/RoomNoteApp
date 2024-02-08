package com.helin.roomnoteapp.data.repo

import com.helin.roomnoteapp.data.datasource.NoteDataSource
import com.helin.roomnoteapp.data.entity.Note


class NoteRepo(val noteDS : NoteDataSource) {

    suspend fun kayit(note_title: String , note_desc: String ) = noteDS.kayit(note_title,note_desc)

    suspend fun guncelle(note_id : Int ,note_title : String , note_desc : String) = noteDS.guncelle(note_id ,note_title , note_desc)

    suspend fun ara(aramaKelimesi : String) = noteDS.ara(aramaKelimesi)

    suspend fun noteYukle() : List<Note> = noteDS.noteYukle()

    suspend fun sil(note_id: Int) = noteDS.sil(note_id)

}