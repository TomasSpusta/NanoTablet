package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spinnertutorial.databinding.InfoFragBinding

class InfoFrag : Fragment() {

// information on main page after login

    private var _binding: InfoFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = InfoFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding!!.textView.text = "Please select one of instruments first"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




