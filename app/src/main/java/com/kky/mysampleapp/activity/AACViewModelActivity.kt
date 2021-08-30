package com.kky.mysampleapp.activity

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import com.kky.mysampleapp.databinding.ActivityAacviewModelBinding
import com.kky.mysampleapp.viewmodel.TestViewModel

class AACViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAacviewModelBinding
    private val viewModel: TestViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAacviewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment = Fragment()
    }
}