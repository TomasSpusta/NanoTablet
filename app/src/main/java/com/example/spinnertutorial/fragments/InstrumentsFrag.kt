package com.example.spinnertutorial.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.Global.reservationMapMap

import com.example.spinnertutorial.MainActivity
import com.example.spinnertutorial.databinding.GeneralFragBinding
import com.example.spinnertutorial.adapters.InstrumentAdapter
import com.example.spinnertutorial.lists.Instrument
import com.example.spinnertutorial.lists.Lists
import com.example.spinnertutorial.network.GetUserFields
import com.example.spinnertutorial.prepareMenu
import com.example.spinnertutorial.reloadInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class InstrumentsFrag : Fragment() {

    //fragment displayed by pressing "Instruments" button

    private lateinit var recyclerView: RecyclerView
    private lateinit var instrumentList: List<Instrument>
    private lateinit var instrumentAdapter: InstrumentAdapter

    private var _binding: GeneralFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = GeneralFragBinding.inflate(inflater, container, false)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = _binding!!.rvGeneral
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)

        instrumentList = Lists.instruments

        instrumentAdapter = InstrumentAdapter(instrumentList)
        recyclerView.adapter = instrumentAdapter

        instrumentAdapter.onItemClick = {
           // reservationMap.putAll(mapOf("Instrument" to it.name,"InstrumentGUID" to it.GUID)) //listOf(it.name,it.GUID)
            //reservationMap["InstrumentGUID"] = it.GUID
            reservationMapMap["Instrument"]!!["Instrument name"] = it.name
            reservationMapMap["Instrument"]!!["Instrument GUID"] = it.GUID



            GlobalScope.launch(Dispatchers.Default) {
                GetUserFields(it.GUID)
                //Log.i("Response_button", GlobalVariables.userFields.toString())
            }
            Thread.sleep(1500)

            prepareMenu(MenuFrag(), requireActivity() as MainActivity)
            reloadInfo(ResInfoFrag(), requireActivity() as MainActivity)

            //Toast.makeText(activity, selectedInstrument, Toast.LENGTH_SHORT).show()
            Log.i("Resp res map", reservationMapMap.toString())
            //reservationMapMap["Instrument"]?.get("Instrument name")?.let { it1 -> Log.i("Resp res map item", it1) }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}




