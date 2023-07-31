package com.example.nano_rfid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nano_rfid.Global.fieldsJSON
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.Global.selectedMenuItem
import com.example.nano_rfid.MainActivity
import com.example.nano_rfid.adapters.GeneralAdapter
import com.example.nano_rfid.databinding.GeneralFragBinding
import com.example.nano_rfid.reloadInfo

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

            reservationMap["Fields"]!!["$selectedMenuItem value"] = it
            fieldsJSON.put("$selectedMenuItem value", it)

            reloadInfo(ResInfoFrag(), requireActivity() as MainActivity)
            Log.i("Resp Res Map", reservationMap.toString())
            Log.i("Resp Res JSON", reservationMap.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

