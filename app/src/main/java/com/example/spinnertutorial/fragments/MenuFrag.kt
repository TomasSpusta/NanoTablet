package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.Global.fieldsOptions
import com.example.spinnertutorial.Global.userFieldsNames
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

        val menuList = userFieldsNames
        val menuListLen = menuList.size
        recyclerView = _binding!!.rvMenu
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)


        menuAdapter = MenuAdapter(menuList)
        recyclerView.adapter = menuAdapter

        menuAdapter.onItemClick = {
            when (it) {
                0 -> replaceFragment(BasicFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                1 -> replaceFragment(BasicFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                2 -> replaceFragment(BasicFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                3 -> replaceFragment(BasicFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                4 -> replaceFragment(BasicFrag(fieldsOptions[it]), requireActivity() as MainActivity)
                5 -> replaceFragment(BasicFrag(fieldsOptions[it]), requireActivity() as MainActivity)
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




