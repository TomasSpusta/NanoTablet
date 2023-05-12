package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

import androidx.fragment.app.Fragment
import com.example.spinnertutorial.R
import com.example.spinnertutorial.databinding.InstrumentsFragBinding
import com.example.spinnertutorial.databinding.MaterialsFragBinding
import com.example.spinnertutorial.lists.Lists

class MaterialsFrag : Fragment() {
    private var _binding: MaterialsFragBinding? = null
    private val binding get() = _binding!!
    lateinit var radioGroup: RadioGroup


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = MaterialsFragBinding.inflate(inflater, container, false)
        radioGroup = binding.radioGroup

        createRadioButtons()

        //val position: FragmentInterface = activity as FragmentInterface
        val material: FragmentInterface = activity as FragmentInterface



        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = binding.root.findViewById(checkedId)
            //position.transferPositions(checkedId)
            material.transferMaterial(radioButton.text.toString())

        }

        return binding.root
    }

    private fun createRadioButtons() {
        //Create list from Instruments in Lists to be only list of strings
        val buttonsList: List<String> = Lists.sampleMaterials
        val numberOfButtons = buttonsList.size


        for (i in 0 until numberOfButtons) {
            val radioButton = RadioButton(activity)

            radioButton.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            radioButton.text = buttonsList[i].toString()
            radioButton.id = i
            radioGroup.addView(radioButton)
        }


    }

}

