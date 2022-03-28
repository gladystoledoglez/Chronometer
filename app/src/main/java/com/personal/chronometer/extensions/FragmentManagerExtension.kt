package com.personal.chronometer.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.personal.chronometer.R

fun FragmentManager.transitionTO(fragment: Fragment, isBackStack: Boolean = true) {
    val transition = beginTransaction().replace(R.id.fcvContainer, fragment)
    if (isBackStack) {
        transition.addToBackStack(fragment.javaClass.simpleName)
    }
    transition.commit()
}