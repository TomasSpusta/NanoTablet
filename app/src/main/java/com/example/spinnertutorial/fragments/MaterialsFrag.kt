package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.databinding.GeneralFragBinding
import com.example.spinnertutorial.fragments.adapters.GeneralAdapter
import com.example.spinnertutorial.lists.Lists
import com.example.spinnertutorial.otherAlertDialog

class MaterialsFrag : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var materialList: List<String>
    private lateinit var materialAdapter: GeneralAdapter

    private var _binding: GeneralFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = GeneralFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        materialList = listOf()
        recyclerView = _binding!!.rvGeneral
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)

        materialList = Lists.sampleMaterials
        materialAdapter = GeneralAdapter(materialList)
        recyclerView.adapter = materialAdapter


        materialAdapter.onItemClick = {

            if (it == "Other") {
                activity?.let { it1 -> otherAlertDialog(it1, model) }
                model.otherInfo.observe(viewLifecycleOwner, Observer { data ->
                    model.storeMaterial(data)
                })
            } else {
                val selectedMaterial = it
                model.storeMaterial(selectedMaterial)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

