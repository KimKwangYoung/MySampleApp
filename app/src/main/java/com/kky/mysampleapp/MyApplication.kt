package com.kky.mysampleapp

import android.app.Application

class MyApplication: Application() {


    companion object {
        lateinit var TAG: String
    }

    override fun onCreate() {
        super.onCreate()
        val appName = getString(R.string.app_name)
        TAG = appName
    }
}