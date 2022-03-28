package com.personal.chronometer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.personal.chronometer.R
import com.personal.chronometer.viewmodels.ChronViewModel
import com.personal.chronometer.viewmodels.ShareViewModel

class ChronFragment : Fragment() {

    private lateinit var chronMinutesView: TextView
    private lateinit var chronSecondsView: TextView

    private val viewModel: ShareViewModel by activityViewModels()
    private val chronViewModel: ChronViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("$TAG onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        println("$TAG onCreateView")
        return inflater.inflate(R.layout.fragment_chron, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("$TAG onViewCreated")
        chronMinutesView = view.findViewById(R.id.minutes)
        chronSecondsView = view.findViewById(R.id.seconds)

        view.findViewById<TextView>(R.id.name).text = viewModel.name

        view.findViewById<Button>(R.id.btn).setOnClickListener {
            chronViewModel.stopChronometer()
        }

        val observerMinutes = Observer { minutes: String ->
            chronMinutesView.text = minutes
        }

        chronViewModel.textMinutes.observe(viewLifecycleOwner, observerMinutes)

        val observerSeconds = Observer { seconds: String ->
            chronSecondsView.text = seconds
        }

        chronViewModel.textSeconds.observe(viewLifecycleOwner, observerSeconds)
    }

    override fun onResume() {
        super.onResume()
        println("$TAG onResume")
        chronViewModel.startChronometer()
    }

    override fun onPause() {
        super.onPause()
        println("$TAG onPause")
        chronViewModel.stopChronometer()
    }

    override fun onStop() {
        super.onStop()
        println("$TAG onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("$TAG onDestroy")
    }

    companion object {
        val TAG: String = ChronFragment::class.java.simpleName

        fun newInstance() = ChronFragment()
    }
}
