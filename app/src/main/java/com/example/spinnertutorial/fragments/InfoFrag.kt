package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.databinding.GeneralFragBinding
import com.example.spinnertutorial.databinding.InfoFragBinding
import com.example.spinnertutorial.fragments.adapters.InstrumentAdapter
import com.example.spinnertutorial.databinding.InstrumentsFragBinding
import com.example.spinnertutorial.lists.Instrument
import com.example.spinnertutorial.lists.Lists

class InfoFrag : Fragment() {



    private var _binding: InfoFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = InfoFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        _binding!!.textView.text = "Please select one of instruments first"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




