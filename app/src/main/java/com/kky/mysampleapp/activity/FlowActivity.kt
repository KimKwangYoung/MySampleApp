package com.kky.mysampleapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.kky.mysampleapp.databinding.ActivityFlowBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowActivity : AppCompatActivity() {

    lateinit var binding: ActivityFlowBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Log.d("TAG", "???")
            flow()
        }
    }

    private fun flowEx() = flow {
        println("Flow started")
        for (i in 1..3) {
            delay(100)
            emit(i)
        }
    }

    private fun flow() = lifecycleScope.launch {
        flowEx().collect { print(it.toString()) }
    }
}