package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TimePicker
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spinnertutorial.R
import com.example.spinnertutorial.databinding.GeneralFragBinding
import com.example.spinnertutorial.databinding.InstrumentsFragBinding
import com.example.spinnertutorial.databinding.LayerFragBinding
import com.example.spinnertutorial.databinding.TimeFragBinding
import com.example.spinnertutorial.fragments.adapters.GeneralAdapter
import com.example.spinnertutorial.lists.Lists
import com.example.spinnertutorial.setupRadioButtons

class TimeFrag : Fragment() {

    private var _binding: TimeFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = TimeFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


        setTime(model)


    }

    private fun setTime(model: SharedViewModel) {
        var selectedTime = 0

        _binding!!.btnPlus.setOnClickListener {
            selectedTime += 5
            _binding!!.tvSetTime.text = selectedTime.toString()
            model.storeTime(selectedTime.toString())
            //Toast.makeText(activity, selectedTime.toString(), Toast.LENGTH_SHORT).show()
        }
        _binding!!.btnMinus.setOnClickListener {
            if (selectedTime <= 0) {
                selectedTime = 0
            } else {
                selectedTime -= 5
            }
            _binding!!.tvSetTime.text = selectedTime.toString()
            model.storeTime(selectedTime.toString())
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
