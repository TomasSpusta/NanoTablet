package com.example.spinnertutorial.lists


object Lists {


    val instruments = listOf(
        InstrumentItem("Fume-hood Solvent I", "cd4d42a8-3453-e311-85a1-005056991551"),
        InstrumentItem("Fume-hood Etching", "d34d42a8-3453-e311-85a1-005056991551"),
        InstrumentItem("Fume-hood HF", "d54d42a8-3453-e311-85a1-005056991551"),
        InstrumentItem("Diener", "655242a8-3453-e311-85a1-005056991551"),
        InstrumentItem("Dektak", "a15042a8-3453-e311-85a1-005056991551"),
        InstrumentItem("ZEISS A2", "a75871be-07e4-e411-86ce-005056991551"),
        InstrumentItem("RFID-TEST", "45856b41-8ae8-ec11-80cd-005056914121")
    )

    val fumehoodSolventOperations = listOf("Resist Stripping", "Au lift-off", "Metal lift-off", "Cleaning", "Other")

    val fumehoodEtchingOperations = listOf(
        "Developement",
        "Resist Stripping",
        "Piranha cleaning",
        "Cleaning",
        "Lift-Off",
        "Cr-Etching",
        "Al-Etching",
        "Au-Etching",
        "Metal etching",
        "K+/Na+",
        "Other"
    )

    val fumehoodHFOperations = listOf("Please select operation", "BOE etch", "HF etch", "HF vapour etcher", "Cleaning", "Other")

    val dienerOperations = listOf("Resist stripping", "Sample cleaning", "Other")

    val dektakOperations = listOf("Sample inspection", "Sample mapping", "Other")

    val zeissA2Operations = listOf("Sample inspection", "Other")

    val additionalLayers = listOf("None", "SiO2", "Si3N4", "Graphene", "Other")

    val sampleMaterials = listOf("Si", "FS", "Glass", "Sapphire", "SiC", "Mask", "Other")

    val sampleSizes = listOf("4 inch", "5x5 inch", "6 inch", "7x7 inch", "10x10 mm", "5x5 mm", "3 inch", "2 inch", "1 inch", "Other")


}

