package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import androidx.core.view.isVisible

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.databinding.GeneralFragBinding
import com.example.spinnertutorial.fragments.adapters.InstrumentAdapter
import com.example.spinnertutorial.databinding.InstrumentsFragBinding
import com.example.spinnertutorial.lists.Instrument
import com.example.spinnertutorial.lists.Lists

class InstrumentsFrag : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var instrumentList: List<Instrument>
    private lateinit var instrumentAdapter: InstrumentAdapter

    private var _binding: GeneralFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = GeneralFragBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        recyclerView = _binding!!.rvGeneral
        recyclerView.setHasFixedSize(true)
       // recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = GridLayoutManager (view.context,2)

        instrumentList = Lists.instruments

        instrumentAdapter = InstrumentAdapter(instrumentList)
        recyclerView.adapter = instrumentAdapter

        instrumentAdapter.onItemClick = {
            val selectedInstrument = it.name
            model.storeInstrument(selectedInstrument)
            Toast.makeText(activity, selectedInstrument, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




