package com.example.spinnertutorial

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.spinnertutorial.lists.Lists

fun setupSpinner(context: Context) {


    val selectedItems = listOf("", "", "", "", "")

    val equipAdapter = EquipAdapter(context, Lists.equipments)

    //initialize adapters for Operations according to the selected Equipment
    val operationAdapter1 = OperationsAdapter(context, Lists.selectOperation)
    val operationAdapter2 = OperationsAdapter(context, Lists.fumehoodSolventOperations)
    val operationAdapter3 = OperationsAdapter(context, Lists.fumehoodEtchingOperations)
    val operationAdapter4 = OperationsAdapter(context, Lists.fumehoodHFOperations)
    val operationAdapter5 = OperationsAdapter(context, Lists.dienerOperations)
    val operationAdapter6 = OperationsAdapter(context, Lists.detakOperations)
    val operationAdapter7 = OperationsAdapter(context, Lists.zeissA2Operations)

    val sampleMaterialAdapter =
        ArrayAdapter(context, R.layout.simple_spinner_dropdown_item, Lists.sampleMaterials)
    val additionalLayerAdapter =
        ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, Lists.additionalLayers)
    val sampleSizeAdapter =
        ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, Lists.sampleSizes)
}

