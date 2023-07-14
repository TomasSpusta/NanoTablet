package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.Global.selectedMenuItem
import com.example.spinnertutorial.MainActivity
import com.example.spinnertutorial.databinding.GeneralFragBinding

import com.example.spinnertutorial.adapters.GeneralAdapter
import com.example.spinnertutorial.reloadInfo

class SubMenuFrag(private val itemList: List<String>) : Fragment() {

    // fragment displaying submenu

    private lateinit var recyclerView: RecyclerView
    private lateinit var subMenuAdapter: GeneralAdapter
    private var _binding: GeneralFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = GeneralFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = _binding!!.rvGeneral
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)


        subMenuAdapter = GeneralAdapter(itemList)
        recyclerView.adapter = subMenuAdapter

        subMenuAdapter.onItemClick = {
           // Log.i("Resp click", it)
            //reservationMap["value"] = it
            //reservationMapMap["value"] = it
            reservationMap["Fields"]!!["$selectedMenuItem value"] = it
            if (it == "Other") {
                Log.i("Resp click", "clicked other")
                /*
                 activity?.let { it1 -> otherAlertDialog(it1, model) }
                 model.otherInfo.observe(viewLifecycleOwner, Observer { data ->
                     model.storeSize(data)
                 })
             } else {
                 model.storeSize(it)
             }
             */

            }
            reloadInfo(ResInfoFrag(), requireActivity() as MainActivity)
            Log.i("Resp Res Map", reservationMap.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

