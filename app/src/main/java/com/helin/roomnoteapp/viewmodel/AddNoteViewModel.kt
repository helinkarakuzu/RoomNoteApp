package com.helin.roomnoteapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.helin.roomnoteapp.data.repo.NoteRepo
import com.helin.roomnoteapp.util.getCurrentDateFormatted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(var noteRepo : NoteRepo) : ViewModel() {

    fun kayit(note_title : String, note_desc : String){
        CoroutineScope(Dispatchers.Main).launch {
            noteRepo.kayit(note_title, note_desc)
        }
    }
}