package com.helin.roomnoteapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helin.roomnoteapp.data.entity.Note
import com.helin.roomnoteapp.data.repo.NoteRepo
import com.helin.roomnoteapp.util.getCurrentDateFormatted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(var noteRepo : NoteRepo) : ViewModel() {

    var noteList = MutableLiveData<List<Note>>()

    init {
        noteYukle()
    }

    fun ara(aramaKelimesi : String) {
        CoroutineScope(Dispatchers.Main).launch {
            noteList.value = noteRepo.ara(aramaKelimesi)
        }
    }

    fun noteYukle(){
        CoroutineScope(Dispatchers.Main).launch{
            noteList.value = noteRepo.noteYukle()
        }
    }

    fun sil(note_id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            noteRepo.sil(note_id)
            noteYukle()
        }
    }

    fun bugununTarihiniAl(): String {
        return Date().getCurrentDateFormatted()
    }

}