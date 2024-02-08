package com.helin.roomnoteapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.helin.roomnoteapp.R
import com.helin.roomnoteapp.databinding.FragmentUpdateBinding
import com.helin.roomnoteapp.util.gecisYap
import com.helin.roomnoteapp.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val bundle : UpdateFragmentArgs by navArgs()
    private lateinit var viewModel : UpdateViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : UpdateViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_update, container, false)
        binding.noteUpdateFragment = this

        binding.noteNesnesi = bundle.note

        return binding.root
    }

    fun update(note_id : Int, note_title : String , note_desc : String ){
        viewModel.guncelle(note_id,note_title, note_desc )
        Toast.makeText(requireContext(),"${note_title} güncellendi 💕" , Toast.LENGTH_SHORT).show()
    }

    fun back(it : View){
        Navigation.gecisYap(it,R.id.updateAnasayfayaGidis)

    }
}
