package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.Global.menuFields
import com.example.spinnertutorial.Global.subMenuFields
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.Global.selectedMenuItem
import com.example.spinnertutorial.MainActivity
import com.example.spinnertutorial.adapters.MenuAdapter

import com.example.spinnertutorial.databinding.MenuFragBinding
import com.example.spinnertutorial.replaceFragment

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

        val menuList = menuFields//userFieldsNames

        recyclerView = _binding!!.rvMenu
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)


        menuAdapter = MenuAdapter(menuList)
        recyclerView.adapter = menuAdapter

        menuAdapter.onItemClick = {
            replaceAndSave(it, requireActivity() as MainActivity)
            /* when (it) {
                    0 -> replaceAndSave(it,requireActivity() as MainActivity)
                    1 -> replaceAndSave(it,requireActivity() as MainActivity)//replaceFragment(SubMenuFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                    2 -> replaceFragment(SubMenuFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                    3 -> replaceFragment(SubMenuFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                    4 -> replaceFragment(SubMenuFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                    5 -> replaceFragment(SubMenuFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                }

                */
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun replaceAndSave(it: Int, activity: MainActivity) {
    if (subMenuFields[it].isEmpty()) {
        Log.i("Resp other", "other was pressed")
        reservationMap["Fields"]!![("$selectedMenuItem value")]=""
        replaceFragment(OtherFrag(), activity)
    //Log.i("Resp sub menu other", subMenuFields[it].toString())
    } else {
        replaceFragment(SubMenuFrag(subMenuFields[it]), activity)
    }

    selectedMenuItem = it.toString()
    //selectedFields[it.toString()] = fieldsOptions[it]
    //reservationMap["$it value"] = subMenuFields [it]
    Log.i("Resp res menu map", reservationMap.toString())
    Log.i("Resp submenu options", subMenuFields[it].toString())

}

