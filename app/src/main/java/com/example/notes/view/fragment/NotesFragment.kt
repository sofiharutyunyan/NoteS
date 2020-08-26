package com.example.notes.view.fragment

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.databinding.FragmentNotesBinding
import com.example.notes.listener.NoteInteractionListener
import com.example.notes.model.Note
import com.example.notes.util.Utils
import com.example.notes.view.adapter.NotesListAdapter
import com.example.notes.view.fragment.base.BaseFragmentWithViewModel
import com.example.notes.viewmodel.NotesViewModel

class NotesFragment : BaseFragmentWithViewModel<FragmentNotesBinding, NotesViewModel>(), NoteInteractionListener {

    private lateinit var adapter : NotesListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Utils.hideKeyboard(context, activity?.currentFocus)
        binding.fragment = this
        initAdapter()
    }

    private fun initAdapter() {
        binding.listNotes.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
        adapter = NotesListAdapter(db.getNoteDao().getAll() as ArrayList<Note>, this)
        binding.listNotes.adapter = adapter
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

    override fun updateNote(note:Note) {
        navigateToWithData(R.id.action_NotesFragment_to_AddNewNoteFragment, note)
        adapter.notifyDataSetChanged()
    }

    override fun deleteNote(note:Note) {
        adapter.removeItem(note)
        db.getNoteDao().delete(note)
    }


}