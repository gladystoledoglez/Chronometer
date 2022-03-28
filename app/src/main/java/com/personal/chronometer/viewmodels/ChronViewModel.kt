package com.personal.chronometer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.personal.chronometer.data.Chronometer

class ChronViewModel : ViewModel() {
    private var chronometer = Chronometer()

    private val _textMinutes = MutableLiveData<String>()
    val textMinutes: LiveData<String> = _textMinutes

    private val _textSeconds = MutableLiveData<String>()
    val textSeconds: LiveData<String> = _textSeconds

    init {
        chronometer.setOnChronoTick { minutes, seconds ->
            _textMinutes.value = minutes.toChronoFormat()
            _textSeconds.value = seconds.toChronoFormat()
        }
    }

    fun startChronometer() {
        chronometer.start()
    }

    fun stopChronometer() {
        chronometer.stop()
    }
}

private fun Int.toChronoFormat(): String =
    if (this / 10 == 0) {
        "0" + toString()
    } else {
        toString()
    }