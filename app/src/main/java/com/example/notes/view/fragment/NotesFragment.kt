package com.example.notes.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.notes.R
import com.example.notes.databinding.FragmentNotesBinding
import com.example.notes.view.fragment.base.BaseFragmentWithViewModel
import com.example.notes.viewmodel.NotesViewModel

class NotesFragment : BaseFragmentWithViewModel<FragmentNotesBinding, NotesViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this

    }

    override fun getViewModelClass(): Class<NotesViewModel> {
        return NotesViewModel::class.java
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_notes
    }

    fun onAddClicked(){
        navigateTo(R.id.action_NotesFragment_to_AddNewNoteFragment)
    }


}