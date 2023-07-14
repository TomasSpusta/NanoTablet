package com.example.spinnertutorial

import com.example.spinnertutorial.Global.subMenuFields
import com.example.spinnertutorial.Global.menuFields
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.Global.userFieldsGUIDs
import com.example.spinnertutorial.Global.userFieldsNames

fun ClearVariables() {
    userFieldsGUIDs = mutableListOf()
    userFieldsNames = mutableListOf()
    subMenuFields = mutableListOf()
    reservationMap = mutableMapOf()
    reservationMap = mutableMapOf(
        "Instrument" to mutableMapOf(),
        "Fields" to mutableMapOf(),
    )
    menuFields = mutableListOf()


}