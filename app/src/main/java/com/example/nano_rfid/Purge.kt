package com.example.nano_rfid

import com.example.nano_rfid.Global.menuFields
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.Global.selectedTime
import com.example.nano_rfid.Global.subMenuFields


fun clearVariables() {

    menuFields.clear() // = mutableListOf()
    subMenuFields.clear() // = mutableListOf()

    reservationMap.clear()

    selectedTime = 0


}

fun clearFields () {
    menuFields.clear()
    subMenuFields.clear()
/*
    reservationMap = mutableMapOf(
        "Instrument" to mutableMapOf<String, String>(),
        "Fields" to mutableMapOf<String, String>(),
        //"User" to mutableMapOf<String, String>(),
    )

 */

    reservationMap["Instrument"]?.clear()

    selectedTime = 0
}