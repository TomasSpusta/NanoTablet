package com.example.nano_rfid

import com.example.nano_rfid.lists.MenuItem
import org.json.JSONObject

object Global {


// MAP tutorial: https://marketsplash.com/tutorials/kotlin/kotlin-map/

    // menu and sub menu fields get from API
    var menuFields = mutableListOf<MenuItem>()
    var subMenuFields = mutableListOf<MutableList<String>>()

    // time variable from time frag
    var selectedTime = 15

    //currently selected menu item, used to create proper values fro submenu items
    var selectedMenuItem = String()

    // reservation matrix with everything important
    var reservationMap = mutableMapOf(
        "Instrument" to mutableMapOf<String, String>() ,
        "Fields" to mutableMapOf<String, String>(),
        "User" to mutableMapOf<String, String>(),

        )

    // reservation matrix in JSON - not in use
    var userJSON = JSONObject()
    var instrumentJSON = JSONObject()
    var fieldsJSON = JSONObject()
    var reservationJSON = JSONObject()

    var nanoTag = "nano"

    var infoList = mutableListOf<String>()
}


