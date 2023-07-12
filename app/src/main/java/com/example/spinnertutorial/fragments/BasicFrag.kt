package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.Global.infoList
import com.example.spinnertutorial.MainActivity
import com.example.spinnertutorial.databinding.GeneralFragBinding

import com.example.spinnertutorial.adapters.GeneralAdapter
import com.example.spinnertutorial.otherAlertDialog
import com.example.spinnertutorial.reloadInfo

class BasicFrag(private val itemList: List<String>) : Fragment() {

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


        zeroAdapter = GeneralAdapter(itemList)
        recyclerView.adapter = zeroAdapter

        zeroAdapter.onItemClick = {
            Log.i("Resp click", it)
            infoList.add(it)
            if (it == "Other") {
                Log.i("Resp click", "clicked other")
                activity?.let { it1 -> otherAlertDialog(it1, model) }
                model.otherInfo.observe(viewLifecycleOwner, Observer { data ->
                    model.storeSize(data)
                })
            } else {
                model.storeSize(it)
            }
            reloadInfo(ReservationFrag(),requireActivity() as MainActivity)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

