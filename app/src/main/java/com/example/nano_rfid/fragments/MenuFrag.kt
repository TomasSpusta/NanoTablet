package com.example.nano_rfid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nano_rfid.Global
import com.example.nano_rfid.Global.menuFields
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.Global.selectedMenuItem
import com.example.nano_rfid.Global.subMenuFields
import com.example.nano_rfid.MainActivity
import com.example.nano_rfid.adapters.MenuAdapter
import com.example.nano_rfid.databinding.MenuFragBinding
import com.example.nano_rfid.reloadInfo
import com.example.nano_rfid.replaceFragment

class MenuFrag : Fragment() {
// Fragment on the left side, displaying menu generated from API

    private lateinit var recyclerView: RecyclerView
    private lateinit var menuAdapter: MenuAdapter
    private var _binding: MenuFragBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = MenuFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuList = menuFields


        recyclerView = _binding!!.rvMenu
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)


        menuAdapter = MenuAdapter(menuList)
        recyclerView.adapter = menuAdapter

        val menuListSize = menuList.size
        for (i in 0..<menuListSize) {
            reservationMap["Fields"]!![("$i name")] = menuFields[i].name
            reservationMap["Fields"]!![("$i GUID")] = menuFields[i].GUID
            reservationMap["Fields"]!![("$i value")] = ""
            //Log.i("Menu, subMenuFields", item.toString())
        }
        reloadInfo(ResInfoFrag(), requireActivity() as MainActivity)

        menuAdapter.onItemClick = {
            replaceAndSave(it, requireActivity() as MainActivity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun replaceAndSave(it: Int, activity: MainActivity) {
    if (subMenuFields[it].isEmpty()) {

        //fieldsJSON.get("Fields").put("$selectedMenuItem value","")
        //reservationMap["Fields"]!![("$selectedMenuItem value")] = ""
        replaceFragment(OtherFrag(), activity)
    } else {
        replaceFragment(SubMenuFrag(subMenuFields[it]), activity)

    }

    selectedMenuItem = it.toString()


    // Log.i("Menu, subMenuFields", subMenuFields[it].toString())
    //Log.i("Menu, selectedMenuItem", selectedMenuItem.toString())
    Log.i("${Global.nanoTag} res map", Global.reservationMap.toString())
}

