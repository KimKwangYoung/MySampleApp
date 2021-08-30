package com.kky.mysampleapp.lifecycle

import android.content.Context
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.kky.mysampleapp.MyApplication
import com.kky.mysampleapp.R

class LifecycleSampleActivity : AppCompatActivity() {
    private lateinit var myLocationListener: MyLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_sample)

        myLocationListener = MyLocationListener(this, lifecycle) { location ->
            // update UI
        }

        myLocationListener.enable()

        lifecycle.addObserver(myLocationListener)

//        supportFragmentManager.beginTransaction().add(R.id.container, LifecycleFragment.newInstance()).commit()
    }


}

internal class MyLocationListener(
    private val context: Context,
    private val lifecycle: Lifecycle,
    private val callback: (Location) -> Unit
): LifecycleObserver {

    private var enabled = false

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (enabled) {
            Log.d(MyApplication.TAG, "ON_START: MyLocationListener")
        }
    }

    fun enable() {
        enabled = true
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        // disconnect if connected
    }
}