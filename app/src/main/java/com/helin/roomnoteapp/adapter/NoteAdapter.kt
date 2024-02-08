package com.helin.roomnoteapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.helin.roomnoteapp.R
import com.helin.roomnoteapp.data.entity.Note
import com.helin.roomnoteapp.databinding.NoteRvItemBinding
import com.helin.roomnoteapp.ui.MainFragmentDirections
import com.helin.roomnoteapp.util.getCurrentDateFormatted
import com.helin.roomnoteapp.viewmodel.MainFragmentViewModel
import java.time.format.DateTimeFormatter
import java.util.Date

class NoteAdapter (var mContext : Context, var noteList: List<Note> , var viewModel: MainFragmentViewModel) : RecyclerView.Adapter<NoteAdapter.CardDesign>()  {

    inner class CardDesign(var design : NoteRvItemBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesign {
        val binding : NoteRvItemBinding  = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.note_rv_item ,parent, false)
        return CardDesign(binding)
    }

    override fun onBindViewHolder(holder: CardDesign, position: Int) {
        val note = noteList.get(position)
        val t = holder.design
        t.noteNesnesi = note

        t.card.setOnClickListener {
            val gecis = MainFragmentDirections.actionMainFragmentToUpdateFragment(note)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.deleteBtn.setOnClickListener {
            Snackbar.make(it , "${note.note_title} silinsin mi?" , Snackbar.LENGTH_INDEFINITE)
                .setAction("Yes"){
                    viewModel.sil(note.note_id)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return noteList.size
    }
}