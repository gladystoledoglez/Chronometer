package com.personal.chronometer.data

import android.os.Handler
import android.os.Looper
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chronometer(var minutes: Int = 0, var seconds: Int = 0) : Parcelable {

    private var chronHandler: Handler = Handler(Looper.getMainLooper())
    private var onChronoTick: ((Int, Int) -> Unit)? = null

    fun setOnChronoTick(listener: (Int, Int) -> Unit) {
        onChronoTick = listener
    }

    private val updateTask = object : Runnable {
        override fun run() {
            updateChronometer()
            chronHandler.postDelayed(this, 1000)
        }
    }

    private fun updateChronometer() {
        seconds++
        if (seconds > 59) {
            minutes++
            seconds = 0
        }
        onChronoTick?.let {
            it(minutes, seconds)
        }
    }

    fun start() {
        chronHandler.post(updateTask)
    }

    fun stop() {
        chronHandler.removeCallbacks(updateTask)
    }
}