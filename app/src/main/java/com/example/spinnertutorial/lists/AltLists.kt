package com.example.spinnertutorial.lists

object AltLists {

    val fumehoodSolventOperations = listOf(
        OperationItem("Resist Stripping", false),
        OperationItem("Au lift-off", false),
        OperationItem("Metal lift-off", false),
        OperationItem("Cleaning", false),
        OperationItem("Other", false)
    )

    val fumehoodEtchingOperations = listOf(
        OperationItem("Developement", false),
        OperationItem("Resist Stripping", false),
        OperationItem("Piranha cleaning", false),
        OperationItem("Cleaning", false),
        OperationItem("Lift-Off", false),
        OperationItem("Cr-Etching", false),
        OperationItem("Al-Etching", false),
        OperationItem("Au-Etching", false),
        OperationItem("Metal etching", false),
        OperationItem("K+/Na+", false),
        OperationItem("Other", false)
    )

    val fumehoodHFOperations = listOf(
        OperationItem("BOE etch", false),
        OperationItem("HF etch", false),
        OperationItem("HF vapour etcher", false),
        OperationItem("Cleaning", false),
        OperationItem("Other", false)
    )

    val dienerOperations = listOf(
        OperationItem("Resist stripping", false),
        OperationItem("Sample cleaning", false),
        OperationItem("Other",false)
    )

    val dektakOperations = listOf(
        OperationItem("Sample inspection",false),
            OperationItem("Sample mapping",false),
                OperationItem("Other",false))

    val zeissA2Operations = listOf(
        OperationItem( "Sample inspection",false),
        OperationItem(  "Other",false))

    val rfidOperations = listOf(
        OperationItem("Sample inspection", false),
        OperationItem("Other",false))

    val ResPars = listOf ( //Reservatiuon parameters which comes from Booking system API
        ResParItem ("Instruments", false),
        ResParItem ("Operations", false),
        ResParItem ("Sample Materials", false),
        ResParItem ("Additional Layers", false),
        ResParItem ("Sample Sizes", false),
        ResParItem ("Pick Time", false))




}