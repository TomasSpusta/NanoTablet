package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.databinding.GeneralFragBinding

import com.example.spinnertutorial.fragments.adapters.OperationsAdapterAlt
import com.example.spinnertutorial.lists.AltLists
import com.example.spinnertutorial.lists.Lists
import com.example.spinnertutorial.lists.OperationItem
import com.example.spinnertutorial.otherAlertDialog

class OperationsFragAlt : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var operationsList: List<OperationItem>
    private lateinit var operationAdapter: OperationsAdapterAlt

    private var _binding: GeneralFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = GeneralFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        operationsList = listOf()
        recyclerView = _binding!!.rvGeneral
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)

        // create list according to instrument
        model.selectedInstrument.observe(viewLifecycleOwner, Observer { data ->
            when (data) {
                Lists.instruments[0].name -> operationsList = AltLists.fumehoodSolventOperations
                Lists.instruments[1].name -> operationsList = AltLists.fumehoodEtchingOperations
                Lists.instruments[2].name -> operationsList = AltLists.fumehoodHFOperations
                Lists.instruments[3].name -> operationsList = AltLists.dienerOperations
                Lists.instruments[4].name -> operationsList = AltLists.dektakOperations
                Lists.instruments[5].name -> operationsList = AltLists.zeissA2Operations
                Lists.instruments[6].name -> operationsList = AltLists.rfidOperations

                else -> Toast.makeText(activity, "Please select Instrument first", Toast.LENGTH_LONG).show()
            }
            operationAdapter = OperationsAdapterAlt(operationsList)
            recyclerView.adapter = operationAdapter

            val selectedOperations = mutableListOf<String>()
            operationAdapter.onItemClick = {
                if (it == "Other") {

                    activity?.let { it1 -> otherAlertDialog(it1, model) }
                    model.otherInfo.observe(viewLifecycleOwner, Observer {data ->
                        val otherOperation = data
                        selectedOperations.clear()
                        selectedOperations.add(otherOperation)
                    })

                } else {
                    selectedOperations.add(it)
                    //Toast.makeText(activity, selectedOperations.toString(), Toast.LENGTH_SHORT).show()

                    // Log.d("operations model", selectedOperations.toString())
                }
                model.storeOperations(selectedOperations)

                // TODO spravit aby sa klidnute/selektnute operations odlisili farbou, ze su vybrate
            }


        }
        )


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

