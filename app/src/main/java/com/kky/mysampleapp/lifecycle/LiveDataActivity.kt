package com.kky.mysampleapp.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kky.mysampleapp.R
import com.kky.mysampleapp.databinding.ActivityLiveDataBinding
import com.kky.mysampleapp.viewmodel.TestViewModel

class LiveDataActivity : AppCompatActivity() {

    val viewModel:TestViewModel by viewModels()

    lateinit var binding: ActivityLiveDataBinding // ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.name().observe(this) { name -> //TestViewModel에 있는 LiveData를 가져와 관찰한다.
            binding.tvName.text = name
        }

//        viewModel.nameLiveData.setValue() -> LiveData 객체 이기 때문에 setValue(), postValue()를 쓸 수 없다.
    }
}