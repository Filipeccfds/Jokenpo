package com.filipe.jokenpo

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class Obsever:DefaultLifecycleObserver,LifecycleEventObserver {

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d("LifeCycles","Observer: ${source.toString()}, event : ${event.toString()}")
    }
}