package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.databinding.ResParFragBinding
import com.example.spinnertutorial.fragments.adapters.ResParAdapter
import com.example.spinnertutorial.lists.AltLists
import com.example.spinnertutorial.lists.Lists
import com.example.spinnertutorial.lists.ResParItem

class ResParFrag : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var resParList: List<ResParItem>
    private lateinit var resParAdapter: ResParAdapter
    private var _binding: ResParFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ResParFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        resParList = listOf()
        recyclerView = _binding!!.rvResPar
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        resParList = listOf(AltLists.ResPars[0])
        resParAdapter = ResParAdapter(resParList)
        recyclerView.adapter = resParAdapter

        resParAdapter.onItemClick = {
            model.storeSelectedItem(it)
        }
        model.selectedInstrument.observe(viewLifecycleOwner, Observer { data ->
            when (data) {
                Lists.instruments[0].name -> resParList = AltLists.ResPars

            }
        })



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




