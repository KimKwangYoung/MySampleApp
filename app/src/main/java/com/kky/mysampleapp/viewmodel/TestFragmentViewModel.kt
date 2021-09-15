package com.kky.mysampleapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kky.mysampleapp.MyApplication

class TestFragmentViewModel: ViewModel() {
    var count = 0

    override fun onCleared() {
        super.onCleared()
        Log.d(MyApplication.TAG, "onCleared")
    }
}