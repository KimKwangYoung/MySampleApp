package com.kky.mysampleapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kky.mysampleapp.R
import com.kky.mysampleapp.lifecycle.LifecycleSampleActivity
import com.kky.mysampleapp.viewmodel.TestViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var testViewModel: TestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.lifecycle_button).setOnClickListener {
            startActivity(Intent(this, LifecycleSampleActivity::class.java))
        }
    }
}