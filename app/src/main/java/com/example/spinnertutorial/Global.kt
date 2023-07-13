package com.example.spinnertutorial

import com.example.spinnertutorial.lists.MenuItem
import org.json.JSONObject

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

    var reservationMap = mutableMapOf<String,Any>(
        "Instrument" to "",
        "InstrumentGUID" to "",
    )


    var reservationMapMap = mutableMapOf(
        "Instrument" to mutableMapOf<String,String>(),
        "Fields" to mutableMapOf<String,String>(),
    )

}


