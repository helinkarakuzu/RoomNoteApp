package com.helin.roomnoteapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.helin.roomnoteapp.R
import com.helin.roomnoteapp.adapter.NoteAdapter
import com.helin.roomnoteapp.databinding.FragmentMainBinding
import com.helin.roomnoteapp.util.gecisYap
import com.helin.roomnoteapp.viewmodel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainFragmentViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main ,container, false)
        binding.mainFragmentNesnesi = this

        binding.titleText = "Notes"

        viewModel.noteList.observe(viewLifecycleOwner){
            val adapter = NoteAdapter(requireContext(),it,viewModel)
            binding.noteAdapter = adapter
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }

            override fun onQueryTextChange(p0: String): Boolean {
                viewModel.ara(p0)
                return true
            }

        })

        return binding.root
    }

    fun ekleBtn(it : View){
        //Extension
        Navigation.gecisYap(it,R.id.ekleGecis)
    }

    override fun onResume() {
        super.onResume()
        viewModel.noteYukle()
    }

}
