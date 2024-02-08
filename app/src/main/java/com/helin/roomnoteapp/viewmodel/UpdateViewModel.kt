package com.helin.roomnoteapp.viewmodel

import androidx.lifecycle.ViewModel
import com.helin.roomnoteapp.data.repo.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(var noteRepo : NoteRepo) : ViewModel(){

    fun guncelle(note_id : Int ,note_title : String , note_desc : String ){
        CoroutineScope(Dispatchers.Main).launch {
            noteRepo.guncelle(note_id ,note_title ,note_desc )
        }
    }

}