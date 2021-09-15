package com.kky.mysampleapp.viewmodel

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import com.google.android.material.tabs.TabLayout
import com.kky.mysampleapp.R
import com.kky.mysampleapp.databinding.ActivityAacviewModelBinding
import com.kky.mysampleapp.viewmodel.TestViewModel

class AACViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAacviewModelBinding
    private val viewModel: TestViewModel by viewModels()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAacviewModelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ViewModelFirstFragment.newInstance()).commit()
                } else {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ViewModelSecondFragment.newInstance()).commit()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })


        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ViewModelFirstFragment.newInstance()).commit()
    }
}