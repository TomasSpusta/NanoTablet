package com.example.nano_rfid.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nano_rfid.Global.projects
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.MainActivity
import com.example.nano_rfid.adapters.ProjectsAdapter
import com.example.nano_rfid.databinding.GeneralFragBinding
import com.example.nano_rfid.lists.ProjectItem
import com.example.nano_rfid.reloadInfo

//fragment displayed by pressing "Instruments" button
class ProjectsFrag : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var List: List<ProjectItem>
    private lateinit var Adapter: ProjectsAdapter

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

        List = projects

        Adapter = ProjectsAdapter(List)
        recyclerView.adapter = Adapter

        Adapter.onItemClick = {

            //instrumentJSON.put("Name", it.name)
            //instrumentJSON.put("GUID", it.GUID)

            reservationMap["Project"]!!["Project name"] = it.name
            reservationMap["Project"]!!["Project GUID"] = it.GUID

            //prepareMenu(MenuFrag(), requireActivity() as MainActivity)
           // Log.i("Info list instrFrag", reservationMap["Fields"].toString())
           // reservationMap["Fields"]?.clear()
            reloadInfo(ResInfoFrag(), requireActivity() as MainActivity)


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}




