package com.kky.mysampleapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kky.mysampleapp.databinding.ActivityAacviewModelBinding

class AACViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAacviewModelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAacviewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}