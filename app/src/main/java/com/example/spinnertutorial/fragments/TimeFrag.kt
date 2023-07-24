package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.Global.selectedTime
import com.example.spinnertutorial.databinding.TimeFragBinding

class TimeFrag : Fragment() {
    // fragment displaying time selection interface
    private var _binding: TimeFragBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = TimeFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //if

        setTime()


    }

    private fun setTime() {


        binding.btnPlus.setOnClickListener {
            selectedTime += 5
            binding.tvSetTime.text = selectedTime.toString()

            //Toast.makeText(activity, selectedTime.toString(), Toast.LENGTH_SHORT).show()
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
