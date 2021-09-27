package com.kky.mysampleapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kky.mysampleapp.MyApplication

class TestViewModel: ViewModel() {

    private val _nameLiveData: MutableLiveData<String> by lazy {
        MutableLiveData()
    }

    fun getNameLiveData(): LiveData<String> = _nameLiveData
}