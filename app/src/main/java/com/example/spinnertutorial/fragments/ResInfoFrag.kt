package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.adapters.ResInfoAdapter

import com.example.spinnertutorial.databinding.ReservationFragBinding

class ResInfoFrag : Fragment() {
// fragment on the right side displaying reservation in preparation

    private lateinit var recyclerView: RecyclerView

    private lateinit var fragAdapter: ResInfoAdapter
    private var _binding: ReservationFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = ReservationFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val infoList = mutableListOf(
            reservationMap["Instrument"]?.get("Instrument name"),
            listItem(0),
            listItem(1),
            listItem(2),
            listItem(3),
            listItem(4),
            listItem(5),
        )

        recyclerView = _binding!!.rvResInfo
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        fragAdapter = ResInfoAdapter(infoList)
        recyclerView.adapter = fragAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun listItem(fieldPosition: Int): String {
    val infoListItem: String?
    if (reservationMap["Fields"]?.get("$fieldPosition name") != null) {
        infoListItem = "${reservationMap["Fields"]?.get("$fieldPosition name")}: ${reservationMap["Fields"]?.get("$fieldPosition value")}"
    } else {
        infoListItem = ""
    }
    return infoListItem
}
