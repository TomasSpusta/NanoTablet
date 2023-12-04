package com.example.nano_rfid.lists


data class Instrument (var name: String, var GUID: String)

data class MenuItem(var name: String, var GUID: String, val fieldType: Int)

data class ProjectItem( val name: String, val GUID:String )