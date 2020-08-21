package com.example.notes.viewmodel

import com.example.notes.viewmodel.base.BaseViewModel

class AddNewNodeViewModel:BaseViewModel(){

    lateinit var title: String
    lateinit var noteBody : String

    fun nodeIsNotEmpty(): Boolean {
        return title.isNotEmpty() && noteBody.isNotEmpty()
    }

    fun createNode() {
        //TODO create Node object and save in DB
    }

}