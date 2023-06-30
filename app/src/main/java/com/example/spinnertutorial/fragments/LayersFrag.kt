package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.R
import com.example.spinnertutorial.databinding.GeneralFragBinding
import com.example.spinnertutorial.databinding.InstrumentsFragBinding
import com.example.spinnertutorial.databinding.LayerFragBinding
import com.example.spinnertutorial.fragments.adapters.GeneralAdapter
import com.example.spinnertutorial.lists.Lists
import com.example.spinnertutorial.otherAlertDialog
import com.example.spinnertutorial.setupRadioButtons

class LayersFrag : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layerList: List<String>
    private lateinit var layerAdapter: GeneralAdapter

    private var _binding: GeneralFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = GeneralFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        layerList = listOf()
        recyclerView = _binding!!.rvGeneral
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)

        layerList = Lists.additionalLayers
        layerAdapter = GeneralAdapter(layerList)
        recyclerView.adapter = layerAdapter

        layerAdapter.onItemClick = {

            if (it == "Other") {
                activity?.let { it1 -> otherAlertDialog(it1, model) }
                model.otherInfo.observe(viewLifecycleOwner, Observer { data ->
                    model.storeLayer(data)
                })
            } else {
                model.storeLayer(it)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
