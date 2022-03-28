package com.personal.chronometer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.personal.chronometer.R
import com.personal.chronometer.extensions.transitionTO
import com.personal.chronometer.viewmodels.ShareViewModel

class NameFragment : Fragment() {

    private val viewModel: ShareViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val label = view.findViewById<EditText>(R.id.inputName)
        val btn = view.findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            viewModel.name = label.text.toString()
            parentFragmentManager.transitionTO(ChronFragment.newInstance())
        }
    }

    companion object {
        fun newInstance() = NameFragment()
    }
}