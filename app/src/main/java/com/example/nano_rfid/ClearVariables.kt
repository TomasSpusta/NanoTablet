package com.example.nano_rfid

import com.example.nano_rfid.Global.menuFields
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.Global.subMenuFields


fun ClearVariables() {

    menuFields = mutableListOf()
    subMenuFields = mutableListOf()

    reservationMap = mutableMapOf(
        "Instrument" to mutableMapOf<String, String>(),
        "Fields" to mutableMapOf<String, String>(),
        "User" to mutableMapOf<String, String>(),

    )


}