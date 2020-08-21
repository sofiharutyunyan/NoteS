package com.example.notes.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.notes.R
import com.example.notes.databinding.FragmentNotesBinding
import com.example.notes.view.fragment.base.BaseFragmentWithViewModel
import com.example.notes.viewmodel.base.NotesViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NotesFragment : BaseFragmentWithViewModel<FragmentNotesBinding, NotesViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

    }

    override fun getViewModelClass(): Class<NotesViewModel> {
        return NotesViewModel::class.java
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_notes
    }
}