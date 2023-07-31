package com.example.nano_rfid.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nano_rfid.Global.selectedTime
import com.example.nano_rfid.databinding.TimeFragBinding

// fragment displaying time selection interface
class TimeFrag : Fragment() {

    private var _binding: TimeFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = TimeFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSetTime.text = selectedTime.toString()
        setTime()

    }

    private fun setTime() {


        binding.btnPlus.setOnClickListener {
            selectedTime += 5
            binding.tvSetTime.text = selectedTime.toString()

        }
        binding.btnMinus.setOnClickListener {
            if (selectedTime <= 0) {
                selectedTime = 0
            } else {
                selectedTime -= 5
            }
            binding.tvSetTime.text = selectedTime.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
