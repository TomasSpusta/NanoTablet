package com.example.nano_rfid


import com.example.nano_rfid.Global.infoList
import com.example.nano_rfid.Global.menuFields
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.Global.selectedTime
import com.example.nano_rfid.Global.subMenuFields


fun clearVariables() {

    menuFields.clear() // = mutableListOf()
    subMenuFields.clear() // = mutableListOf()


    reservationMap["Instrument"]?.clear()
    reservationMap["User"]?.clear()
    reservationMap["Fields"]?.clear()

    selectedTime = 15


}

fun clearFields() {
    menuFields.clear()
    subMenuFields.clear()
    infoList.clear()
    reservationMap["Instrument"]?.clear()
    reservationMap["Fields"]?.clear()

    selectedTime = 15
}