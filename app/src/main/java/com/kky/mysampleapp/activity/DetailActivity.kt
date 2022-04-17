package com.kky.mysampleapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.kky.mysampleapp.R
import com.kky.mysampleapp.databinding.ActivityDetailBinding
import com.kky.mysampleapp.fragment.lifecycle.FirstFragment
import com.kky.mysampleapp.fragment.lifecycle.SecondFragment

class DetailActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }

    lateinit var currentFragment: Fragment

    val firstFragment = FirstFragment.newInstance()
    val secondFragment = SecondFragment.newInstance()

    companion object {
        const val TAG = "[Detail]"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fm = supportFragmentManager

        if (savedInstanceState == null) {
            fm.beginTransaction()
                .replace(R.id.container, firstFragment, "FirstFragment")
                .commit()
            currentFragment = firstFragment
        }

        binding.change.setOnClickListener {
            when(currentFragment) {
                is FirstFragment -> {
                    fm.beginTransaction().replace(R.id.container, secondFragment).commit()
                    currentFragment = secondFragment
                }

                is SecondFragment -> {
                    fm.beginTransaction().replace(R.id.container, firstFragment).commit()
                    currentFragment = firstFragment
                }
            }
        }

        Log.d(TAG, "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        Log.d(TAG, "onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy()")
        super.onDestroy()
        Log.d(TAG, isFinishing.toString())
    }

}