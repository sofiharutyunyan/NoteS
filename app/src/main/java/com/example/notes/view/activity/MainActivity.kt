package com.example.notes.view.activity

import android.os.Bundle
import com.example.notes.R
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.view.activity.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)

    }

}