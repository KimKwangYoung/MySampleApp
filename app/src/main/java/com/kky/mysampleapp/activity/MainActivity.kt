package com.kky.mysampleapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.kky.mysampleapp.R
import com.kky.mysampleapp.lifecycle.LifecycleSampleActivity
import com.kky.mysampleapp.viewmodel.TestViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var testViewModel: TestViewModel

    companion object {
        const val TAG = "[Main]"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.lifecycle_button).setOnClickListener {
            startActivity(Intent(this, LifecycleSampleActivity::class.java))
        }

        findViewById<Button>(R.id.coordinator_button).setOnClickListener {
            startActivity(Intent(this, CoordinatorLayoutActivity::class.java))
        }

        findViewById<Button>(R.id.detail).setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }

//    override fun onStart() {
//        super.onStart()
//        Log.d(TAG, "onStart()")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d(TAG, "onResume()")
//    }
//
//    override fun onPause() {
//        Log.d(TAG, "onPause()")
//        super.onPause()
//    }
//
//    override fun onStop() {
//        Log.d(TAG, "onStop()")
//        super.onStop()
//    }
//
//    override fun onDestroy() {
//        Log.d(TAG, "onDestroy()")
//        super.onDestroy()
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Log.d(TAG, "onRestart()")
//    }
}