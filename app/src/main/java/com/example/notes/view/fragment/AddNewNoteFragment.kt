package com.example.notes.view.fragment

import android.os.Bundle
import android.view.View
import com.example.notes.R
import com.example.notes.databinding.FragmentAddNewNoteBinding
import com.example.notes.view.fragment.base.BaseFragmentWithViewModel
import com.example.notes.viewmodel.AddNewNodeViewModel

class AddNewNoteFragment : BaseFragmentWithViewModel<FragmentAddNewNoteBinding, AddNewNodeViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        vm.title = binding.edtTitle.text.toString()
        vm.noteBody = binding.edtNoteBody.text.toString()
    }

    override fun getViewModelClass(): Class<AddNewNodeViewModel> {
        return AddNewNodeViewModel::class.java
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_add_new_note
    }
}