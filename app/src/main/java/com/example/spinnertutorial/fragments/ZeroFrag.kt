package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.Global.subMenuFields
import com.example.spinnertutorial.databinding.GeneralFragBinding

import com.example.spinnertutorial.adapters.GeneralAdapter
import com.example.spinnertutorial.otherAlertDialog

class ZeroFrag : Fragment() {
//
    private lateinit var recyclerView: RecyclerView

    private lateinit var zeroAdapter: GeneralAdapter

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
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)

        val zeroList = subMenuFields.get(2)
        zeroAdapter = GeneralAdapter(zeroList)
        recyclerView.adapter = zeroAdapter

        zeroAdapter.onItemClick = {

            if (it == "Other") {
                activity?.let { it1 -> otherAlertDialog(it1, model) }
                model.otherInfo.observe(viewLifecycleOwner, Observer { data ->
                    model.storeSize(data)
                })
            } else {
                model.storeSize(it)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

