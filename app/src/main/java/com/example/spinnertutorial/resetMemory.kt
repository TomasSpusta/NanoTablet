package com.example.spinnertutorial

import com.example.spinnertutorial.fragments.SharedViewModel

fun resetMemory (model: SharedViewModel) {
    model.selectedInstrument.value = null
    model.selectedOperations.value = null
    model.selectedMaterial.value = null
    model.selectedLayer.value = null
    model.selectedSize.value = null
    model.selectedTime.value = null
    model.otherInfo.value = null
}