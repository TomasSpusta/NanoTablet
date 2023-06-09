package com.example.spinnertutorial.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.spinnertutorial.R

import com.example.spinnertutorial.databinding.OperationsFragBinding
import com.example.spinnertutorial.lists.Lists

class OperationsFrag : Fragment(), FragmentInterface {
    private var _binding: OperationsFragBinding? = null
    private val binding get() = _binding!!
    lateinit var radioGroup: RadioGroup
    lateinit var selectedInstrument: String
    lateinit var buttonsList: List<String>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = OperationsFragBinding.inflate(inflater, container, false)
        radioGroup = binding.radioGroup
       // selectedInstrument = instrume
        //buttonsList = Lists.fumehoodSolventOperations

        when (selectedInstrument) {
            Lists.instruments[0].name -> Toast.makeText(activity, selectedInstrument, Toast.LENGTH_SHORT).show() //buttonsList = Lists.fumehoodSolventOperations
            Lists.instruments[1].name -> Toast.makeText(activity, selectedInstrument, Toast.LENGTH_SHORT).show() //buttonsList = Lists.fumehoodEtchingOperations
            else -> Toast.makeText(activity, selectedInstrument, Toast.LENGTH_SHORT).show()
        }

        createRadioButtons()

        // val position: FragmentInterface = activity as FragmentInterface

        val operation: FragmentInterface = activity as FragmentInterface

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButton: RadioButton = binding.root.findViewById(checkedId)
            //position.transferPositions(checkedId)
            operation.transferOperations(listOf(radioButton.text.toString()))
        }

        return binding.root
    }

    private fun createRadioButtons() {


//TODO: tady je misto, kde sa bude rozhodovat, jake butonky se vytvori na zaklade toho, jaky sa vybral Instrument
        // TODO: proto je potreba dostat data z Instrument fragmentu
println( selectedInstrument)


        //  val buttonsList: List<String> = Lists.fumehoodEtchingOperations


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

    override fun transferInstrument(instrument: String) {
        selectedInstrument = instrument
    }

    override fun transferOperations(operations: List<String>) {

    }

    override fun transferMaterial(material: String) {
    }

    override fun transferLayer(layer: String) {
    }

    override fun transferSize(size: String) {
    }
}


