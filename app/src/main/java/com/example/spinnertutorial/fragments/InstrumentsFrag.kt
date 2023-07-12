package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.Global.instrumentGUID
import com.example.spinnertutorial.Global.userFieldsNames
import com.example.spinnertutorial.MainActivity
import com.example.spinnertutorial.databinding.GeneralFragBinding
import com.example.spinnertutorial.adapters.InstrumentAdapter
import com.example.spinnertutorial.lists.Instrument
import com.example.spinnertutorial.lists.Lists
import com.example.spinnertutorial.network.GetUserFields
import com.example.spinnertutorial.prepareMenu
import com.example.spinnertutorial.replaceFragment
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        recyclerView = _binding!!.rvGeneral
        recyclerView.setHasFixedSize(true)
        // recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)

        instrumentList = Lists.instruments

        instrumentAdapter = InstrumentAdapter(instrumentList)
        recyclerView.adapter = instrumentAdapter

        instrumentAdapter.onItemClick = {
            val selectedInstrument = it.name
            //model.storeInstrument(selectedInstrument)
            instrumentGUID = it.instrumentGUID

            GlobalScope.launch(Dispatchers.Default) {
                GetUserFields(instrumentGUID)
                //Log.i("Response_button", GlobalVariables.userFields.toString())
            }
            Thread.sleep(1000)

            prepareMenu(MenuFrag(), requireActivity() as MainActivity)

            //Toast.makeText(activity, selectedInstrument, Toast.LENGTH_SHORT).show()
            //Log.i("Resp equip name", userFieldsNames.toString())

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}




