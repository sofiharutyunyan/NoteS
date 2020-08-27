package com.example.notes.view.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notes.model.Adaptable
import com.example.notes.util.ConstantsBundle

abstract class BaseFragment<T : ViewDataBinding> : Fragment() {

    protected lateinit var binding: T

    abstract fun getLayoutResource(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(layoutInflater, getLayoutResource(), container, false)
        return binding.root
    }

    fun navigateTo(resId:Int){
        findNavController().navigate(resId)
    }

    fun navigateToWithData(resId:Int, adaptable: Adaptable){
        val bundle = Bundle()
        bundle.putParcelable(ConstantsBundle.updatebleNote, adaptable)
        findNavController().navigate(resId, bundle)
    }

}
