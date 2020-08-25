package com.example.notes.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.notes.R
import com.example.notes.databinding.FragmentAddNewNoteBinding
import com.example.notes.listener.NoteInteractionListener
import com.example.notes.model.Note
import com.example.notes.view.fragment.base.BaseFragmentWithViewModel
import com.example.notes.viewmodel.AddNewNodeViewModel

class AddNewNoteFragment : BaseFragmentWithViewModel<FragmentAddNewNoteBinding, AddNewNodeViewModel>(){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        vm.note = Note(null, binding.edtTitle.text.toString(), binding.edtNoteBody.text.toString())

    }

    override fun getViewModelClass(): Class<AddNewNodeViewModel> {
        return AddNewNodeViewModel::class.java
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_add_new_note
    }

    fun onSaveClicked(){
        if (nodeIsNotEmpty()){
            addNote()
        } else {
            Toast.makeText(context, getString(R.string.empty_note_error_msg), Toast.LENGTH_LONG).show()
        }
    }

    private fun nodeIsNotEmpty(): Boolean{
        return binding.edtTitle.text.isNotEmpty() && binding.edtNoteBody.text.isNotEmpty()
    }

    private fun addNote(){
        navigateTo(R.id.action_AddNewNoteFragment_to_NotesFragment)
        vm.note = Note(null, binding.edtTitle.text.toString(), binding.edtNoteBody.text.toString())
        db.getNoteDao().insert(vm.note)
    }
}