package com.example.spinnertutorial.lists


data class Instrument (var name: String, var GUID: String)
data class OperationItem (var name: String, var isSelected: Boolean)

data class MenuItem(var name: String, var GUID: String, val fieldType: Int)