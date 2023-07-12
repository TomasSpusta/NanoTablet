package com.example.spinnertutorial

import android.annotation.SuppressLint
import com.example.spinnertutorial.Global.selectedInstrumentGUID
import com.example.spinnertutorial.Global.selectedInstrument
import com.example.spinnertutorial.databinding.ActivityMainBinding
import com.example.spinnertutorial.fragments.SharedViewModel

@SuppressLint("SetTextI18n")
fun prepareReservation   (model :SharedViewModel, binding: ActivityMainBinding

) {
/*
    val resPayload = mutableMapOf(
        "instrument" to model.selectedInstrument.value.toString(),
        "operations" to model.selectedOperations.value.toString(),
        "material" to model.selectedMaterial.value.toString(),
        "layer" to model.selectedLayer.value.toString(),
        "size" to model.selectedSize.value.toString(),
        "time" to model.selectedTime.value.toString()
    )

 */

// values from fields for reservation
    val  reservationPayload= mutableMapOf(
        "instrument" to selectedInstrument,
        "instrumentGUID" to selectedInstrumentGUID,
        "field1" to model.selectedOperations.value.toString(),
        "field2" to model.selectedMaterial.value.toString(),
        "field3" to model.selectedLayer.value.toString(),
        "field4" to model.selectedSize.value.toString(),
        "field5" to model.selectedTime.value.toString(),
        "field6" to model.selectedTime.value.toString()
    )

/*
    binding.reservationPayload.text = "Preparing reservation: \n" +
            resPayload["instrument"] + "\n" +
            resPayload["operations"] + "\n" +
            resPayload["material"] + "\n" +
            resPayload["layer"] + "\n" +
            resPayload["size"] + "\n" +
            resPayload["time"] + " minutes"



*/
}
