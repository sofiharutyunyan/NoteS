package com.example.notes.view.fragment.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.example.notes.apiService.AppDatabase
import com.example.notes.viewmodel.base.BaseViewModel

abstract class BaseFragmentWithViewModel<T : ViewDataBinding, U : BaseViewModel> : BaseFragment<T>() {

    protected lateinit var vm: U

    lateinit var db: AppDatabase

    protected abstract fun getViewModelClass(): Class<U>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = initDB()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProviders.of(this).get(getViewModelClass())
    }

    private fun initDB(): AppDatabase {
        return AppDatabase.getInstance(context)!!
    }

}