package com.example.spinnertutorial.fragments

interface FragmentInterface {

    //fun transferPositions(position: Int) //TODO: Pravdepodobne to budu muset byt listy/listofArrays
    //fun transferNames(name: String) //TODO: Pravdepodobne to budu muset byt listy/listofArrays
    fun transferInstrument(instrument: String)
    fun transferOperations(operations: List<String>)
    fun transferMaterial(material: String)
    fun transferLayer(layer: String)
    fun transferSize(size: String)


}