package com.example.spinnertutorial.lists


object Lists {

    val additionalLayers = listOf("Please select additional layer", "None", "SiO2", "Si3N4", "Graphene", "Other")

    val equipments = listOf(
        EquipmentItem("Please select equipment", "0"),
        EquipmentItem("Fume-hood Solvent I", "cd4d42a8-3453-e311-85a1-005056991551"),
        EquipmentItem("Fume-hood Etching", "d34d42a8-3453-e311-85a1-005056991551"),
        EquipmentItem("Fume-hood HF", "d54d42a8-3453-e311-85a1-005056991551"),
        EquipmentItem("Diener", "655242a8-3453-e311-85a1-005056991551"),
        EquipmentItem("Dektak", "a15042a8-3453-e311-85a1-005056991551"),
        EquipmentItem("ZEISS A2", "a75871be-07e4-e411-86ce-005056991551"),
        EquipmentItem("RFID-TEST", "45856b41-8ae8-ec11-80cd-005056914121")
    )

    val selectOperation = listOf(
        OperationItem("Please select operation", false)
    )

    val fumehoodSolventOperations = listOf(

        OperationItem("Resist Stripping", false),
        OperationItem("Au lift-off", false),
        OperationItem("Metal lift-off", false),
        OperationItem("Cleaning", false),
        OperationItem("Other", false)
    )

    val fumehoodEtchingOperations = listOf(
        OperationItem("Please select operation", false),
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
        OperationItem("Please select operation", false),
        OperationItem("BOE etch", false),
        OperationItem("HF etch", false),
        OperationItem("HF vapour etcher", false),
        OperationItem("Cleaning", false),
        OperationItem("Other", false)
    )

    val dienerOperations = listOf(
        OperationItem("Please select operation", false),
        OperationItem("Resist stripping", false),
        OperationItem("Sample cleaning", false),
        OperationItem("Other", false)
    )

    val detakOperations = listOf(
        OperationItem("Please select operation", false),
        OperationItem("Sample inspection", false),
        OperationItem("Sample mapping", false),
        OperationItem("Other", false)
    )

    val zeissA2Operations = listOf(
        OperationItem("Please select operation", false),
        OperationItem("Sample inspection", false),
        OperationItem("Other", false)
    )

    val sampleMaterials = listOf(
        "Please select sample material",
        ("Si"),
        ("FS"),
        ("Glass"),
        ("Sapphire"),
        ("SiC"),
        ("Mask"),
        ("Other")
    )

    val sampleSizes = listOf(
        "Please select sample size",
        ("4 inch"),
        ("5x5 inch"),
        ("6 inch"),
        ("7x7 inch"),
        ("10x10 mm"),
        ("5x5 mm"),
        ("3 inch"),
        ("2 inch"),
        ("1 inch"),
        ("Other")
    )

}