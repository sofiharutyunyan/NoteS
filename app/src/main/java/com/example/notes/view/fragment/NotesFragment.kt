package com.example.notes.view.fragment

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.databinding.FragmentNotesBinding
import com.example.notes.model.Note
import com.example.notes.view.adapter.NotesListAdapter
import com.example.notes.view.fragment.base.BaseFragmentWithViewModel
import com.example.notes.viewmodel.NotesViewModel

class NotesFragment : BaseFragmentWithViewModel<FragmentNotesBinding, NotesViewModel>() {

    private lateinit var adapter : NotesListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        initAdapter()
    }

    private fun initAdapter() {
        binding.listNotes.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
        adapter = NotesListAdapter(db.getNoteDao().getAll() as ArrayList<Note>)
        binding.listNotes.adapter = adapter
    }

    override fun getViewModelClass(): Class<NotesViewModel> {
        return NotesViewModel::class.java
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_notes
    }

    override fun onResume() {
        super.onResume()
    }

    fun onAddClicked(){
        navigateTo(R.id.action_NotesFragment_to_AddNewNoteFragment)
    }


}