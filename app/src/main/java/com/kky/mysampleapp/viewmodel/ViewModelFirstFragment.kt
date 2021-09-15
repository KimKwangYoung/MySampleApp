package com.kky.mysampleapp.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kky.mysampleapp.MyApplication
import com.kky.mysampleapp.R

class ViewModelFirstFragment : Fragment() {

    val viewModel: TestFragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.count++
        Log.d(MyApplication.TAG, "${viewModel.count}")
        return inflater.inflate(R.layout.fragment_view_model_first, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ViewModelFirstFragment().apply {}
    }
}