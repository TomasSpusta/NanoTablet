package com.example.nano_rfid.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//https://www.geeksforgeeks.org/fragment-to-fragment-communication-in-android-using-shared-viewmodel/

class SharedViewModel : ViewModel() {
    val selectedInstrument = MutableLiveData<String>()
    val selectedOperations = MutableLiveData<List<String>>()
    val selectedMaterial = MutableLiveData<String>()
    val selectedLayer = MutableLiveData<String>()
    val selectedSize = MutableLiveData<String>()
    val selectedTime = MutableLiveData<String>()
    val otherInfo = MutableLiveData<String>()
    val selectedItem = MutableLiveData<Int> ()


    fun storeInstrument (storedInstrument: String) {
        selectedInstrument.value = storedInstrument
    }

    fun storeOperations (storedOperations: List<String>) {
        selectedOperations.value = storedOperations
    }

    fun storeMaterial (storedMaterial: String) {
        selectedMaterial.value = storedMaterial
    }

    fun storeLayer (storedLayer: String) {
        selectedLayer.value = storedLayer
    }

    fun storeSize (storedSize: String) {
        selectedSize.value = storedSize
    }
    fun storeTime (storedTime: String) {
        selectedTime.value = storedTime
    }

    fun storeOther (storedOther: String) {
        otherInfo.value = storedOther
    }

    fun storeSelectedItem (storedSelectedItem: Int) {
        selectedItem.value = storedSelectedItem
    }



}