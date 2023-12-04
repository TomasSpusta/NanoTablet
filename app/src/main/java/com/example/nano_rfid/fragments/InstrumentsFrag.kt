package com.example.nano_rfid.fragments

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
import com.example.nano_rfid.Global.instrumentJSON
import com.example.nano_rfid.Global.menuFields
import com.example.nano_rfid.Global.reservationJSON
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.Global.subMenuFields
import com.example.nano_rfid.MainActivity
import com.example.nano_rfid.adapters.InstrumentAdapter
import com.example.nano_rfid.databinding.GeneralFragBinding
import com.example.nano_rfid.lists.Instrument
import com.example.nano_rfid.lists.Lists
import com.example.nano_rfid.network.GetUserFields
import com.example.nano_rfid.prepareMenu
import com.example.nano_rfid.reloadInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//fragment displayed by pressing "Instruments" button
class InstrumentsFrag : Fragment() {

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

            instrumentJSON.put("Name", it.name)
            instrumentJSON.put("GUID", it.GUID)

            reservationMap["Instrument"]!!["Instrument name"] = it.name
            reservationMap["Instrument"]!!["Instrument GUID"] = it.GUID



            GlobalScope.launch(Dispatchers.Default) {

                GetUserFields(it.GUID)
                //Log.i("Response_button", GlobalVariables.userFields.toString())

            }
            Thread.sleep(1000)
            //Log.i("Menu fields", menuFields.toString())

            prepareMenu(MenuFrag(), requireActivity() as MainActivity)
           // Log.i("Info list instrFrag", reservationMap["Fields"].toString())
            reservationMap["Fields"]?.clear()
            reloadInfo(ResInfoFrag(), requireActivity() as MainActivity)


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}




