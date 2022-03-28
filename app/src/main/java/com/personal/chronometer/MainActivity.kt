package com.personal.chronometer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.personal.chronometer.extensions.transitionTO
import com.personal.chronometer.fragments.NameFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null)
            return
        supportFragmentManager.transitionTO(NameFragment.newInstance(), isBackStack = false)
    }
}