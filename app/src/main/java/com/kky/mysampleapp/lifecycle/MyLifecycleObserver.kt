package com.kky.mysampleapp.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.kky.mysampleapp.MyApplication

class MyLifecycleObserver(private val lifecycleOwner: LifecycleOwner, private val lifecycle: Lifecycle): LifecycleObserver {
    private val tag = lifecycleOwner.javaClass.name

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateEvent() {
        checkEventAndState("EVENT: ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartEvent() {
        checkEventAndState("EVENT: ON_START")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeEvent() {
        checkEventAndState("EVENT: ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseEvent() {
        checkEventAndState("EVENT: ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopEvent() {
        checkEventAndState("EVENT: ON_STOP")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyEvent() {
        checkEventAndState("EVENT: ON_DESTROY")
    }

    private fun checkEventAndState(event: String) {
        Log.d(MyApplication.TAG, event)
        Log.d(MyApplication.TAG, lifecycle.currentState.toString())
    }

}