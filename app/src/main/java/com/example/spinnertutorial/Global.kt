package com.example.spinnertutorial

import com.example.spinnertutorial.lists.MenuItem

object Global {

    var selectedInstrument = ""
    var selectedInstrumentGUID = ""

// MAP tutorial: https://marketsplash.com/tutorials/kotlin/kotlin-map/

    var menuFields = mutableListOf<MenuItem>()

    var selectedTime = 0

    var userFieldsGUIDs = mutableListOf<String>()
    var userFieldsNames = mutableListOf<String>()

    var subMenuFields = mutableListOf<MutableList<String>>()

var selectedMenuItem = String()




    var reservationMap = mutableMapOf(
        "Instrument" to mutableMapOf<String,String>(),
        "Fields" to mutableMapOf<String,String>(),
    )

}


