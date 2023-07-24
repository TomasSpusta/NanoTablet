package com.example.spinnertutorial

import com.example.spinnertutorial.Global.menuFields
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.Global.subMenuFields


fun ClearVariables() {

    menuFields = mutableListOf()
    subMenuFields = mutableListOf()

    reservationMap = mutableMapOf(
        "Instrument" to mutableMapOf<String, String>(),
        "Fields" to mutableMapOf<String, String>(),
        "User" to mutableMapOf<String, String>(),

    )


}