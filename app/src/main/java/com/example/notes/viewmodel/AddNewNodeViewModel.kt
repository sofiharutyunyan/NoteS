package com.example.notes.viewmodel

import com.example.notes.model.Note
import com.example.notes.viewmodel.base.BaseViewModel

class AddNewNodeViewModel : BaseViewModel() {

     var note: Note = Note(-1, "", "")

}