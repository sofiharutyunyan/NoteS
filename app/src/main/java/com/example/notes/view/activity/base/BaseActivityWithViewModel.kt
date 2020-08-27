package com.example.notes.view.activity.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.notes.viewmodel.base.BaseViewModel

abstract class BaseActivityWithViewModel<T : ViewDataBinding, U : BaseViewModel> : BaseActivity<T>() {

    protected lateinit var vm : U

    protected abstract fun getViewModelClass(): Class<U>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm  = ViewModelProvider(this).get(getViewModelClass())
    }
}