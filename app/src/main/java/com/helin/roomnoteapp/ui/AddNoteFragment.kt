package com.helin.roomnoteapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.helin.roomnoteapp.R
import com.helin.roomnoteapp.databinding.FragmentAddNoteBinding
import com.helin.roomnoteapp.util.gecisYap
import com.helin.roomnoteapp.util.getCurrentDateFormatted
import com.helin.roomnoteapp.viewmodel.AddNoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNoteBinding
    private lateinit var viewModel : AddNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddNoteViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_note, container, false)
        binding.addNoteNesnesi = this

        return binding.root
    }

    fun kayit(note_title : String,  note_desc : String ){
        viewModel.kayit(note_title,note_desc)
        Toast.makeText(requireContext(),"Note save successfully 💕" , Toast.LENGTH_SHORT).show()
    }

    fun back(it : View){
        Navigation.gecisYap(it,R.id.addNoteAnasayfayaGidis)
    }



}