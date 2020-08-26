package com.example.notes.view.fragment

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.example.notes.R
import com.example.notes.databinding.FragmentAddNewNoteBinding
import com.example.notes.listener.NoteInteractionListener
import com.example.notes.model.Note
import com.example.notes.util.ConstantsBundle
import com.example.notes.view.fragment.base.BaseFragmentWithViewModel
import com.example.notes.viewmodel.AddNewNodeViewModel

class AddNewNoteFragment : BaseFragmentWithViewModel<FragmentAddNewNoteBinding, AddNewNodeViewModel>(){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        vm.note = Note(null, binding.edtTitle.text.toString(), binding.edtNoteBody.text.toString())
        initArguments()

    }

    private fun initArguments() {
        if (arguments != null){
            vm.isNewNote = false
            vm.note = requireArguments().getParcelable(ConstantsBundle.updatebleNote)!!
            binding.edtTitle.setText(vm.note.title)
            binding.edtNoteBody.setText(vm.note.noteBody)
        }
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
        vm.note.title = binding.edtTitle.text.toString()
        vm.note.noteBody = binding.edtNoteBody.text.toString()
        if (vm.isNewNote){
            db.getNoteDao().insert(vm.note)
        } else {
            db.getNoteDao().update(vm.note)
        }

    }
}