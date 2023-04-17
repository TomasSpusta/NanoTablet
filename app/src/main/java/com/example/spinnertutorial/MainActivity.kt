package com.example.spinnertutorial


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.spinnertutorial.lists.Lists
import com.example.spinnertutorial.network.CRMResM
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWeb = findViewById<WebView>(R.id.web_view)
        // Web view will display web site of cf nano to see reservations
        setupWebView(myWeb)

        // Set up spinner for equip, operations...
        setupSpinner()

        // Checking the selected time of reservation
        // checkTime()


    }

    private fun checkTime() {
        //https://www.youtube.com/watch?v=0wZwLfmVTvU&ab_channel=CodeWithMazn
        var selectedTime: Int
        val reservationTimeBar = findViewById<SeekBar>(R.id.SB_time_bar)
        val selectedTimeNumber = findViewById<TextView>(R.id.tv_reservation_time_number)
        reservationTimeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                selectedTime = (reservationTimeBar.progress * 15)
                selectedTimeNumber.text = "${selectedTime} minutes"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // selectedTimeNumber.text = "${selectedTime} minutes"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupSpinner() {
        // create list of selected items which will be passed to the booking system API
        val selectedItems = mutableListOf("", "", "", "", "")

        //initialize adapter for Equipments
        val equipAdapter = EquipAdapter(this, Lists.equipments)

//initialize adapters for Operations according to the selected Equipment
        val operationAdapter1 = OperationsAdapter(this, Lists.selectOperation)
        val operationAdapter2 = OperationsAdapter(this, Lists.fumehoodSolventOperations)
        val operationAdapter3 = OperationsAdapter(this, Lists.fumehoodEtchingOperations)
        val operationAdapter4 = OperationsAdapter(this, Lists.fumehoodHFOperations)
        val operationAdapter5 = OperationsAdapter(this, Lists.dienerOperations)
        val operationAdapter6 = OperationsAdapter(this, Lists.detakOperations)
        val operationAdapter7 = OperationsAdapter(this, Lists.zeissA2Operations)

// initialize array adapter for Materials
        val sampleMaterialAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Lists.sampleMaterials)

        //initialize array adapter for Additional layers
        val additionalLayerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Lists.additionalLayers)

//initialize array adapter for Sample size
        val sampleSizeAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Lists.sampleSizes)

        // find spinners by view ID in activity_main.xml file
        val spinEquipment: Spinner = findViewById(R.id.spin_equipment)
        val spinOperation: Spinner = findViewById(R.id.spin_operations)
        val spinMaterial: Spinner = findViewById(R.id.spin_sample_material)
        val spinAdditionalLayer: Spinner = findViewById(R.id.spin_additional_layer)
        val spinSampleSize: Spinner = findViewById(R.id.spin_sample_size)

        // connect/put adapters data to spinners, operations will be declared later
        spinEquipment.adapter = equipAdapter
        spinMaterial.adapter = sampleMaterialAdapter
        spinAdditionalLayer.adapter = additionalLayerAdapter
        spinSampleSize.adapter = sampleSizeAdapter

        //When some equipment is selected, operations list will be changed accordingly
        spinEquipment.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val selectedEquipName = Lists.equipments[position]
                val selectedEquipNumber = Lists.equipments[position].equipmentNumber

                selectedItems[0] = selectedEquipNumber

                when (selectedEquipName) {
                    Lists.equipments[0] -> spinOperation.adapter = operationAdapter1
                    Lists.equipments[1] -> spinOperation.adapter = operationAdapter2
                    Lists.equipments[2] -> spinOperation.adapter = operationAdapter3
                    Lists.equipments[3] -> spinOperation.adapter = operationAdapter4
                    Lists.equipments[4] -> spinOperation.adapter = operationAdapter5
                    Lists.equipments[5] -> spinOperation.adapter = operationAdapter6
                    Lists.equipments[6] -> spinOperation.adapter = operationAdapter7
                    Lists.equipments[7] -> spinOperation.adapter = operationAdapter7
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinOperation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                selectedItems[1] = selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinAdditionalLayer.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val selectedItem = parent!!.getItemAtPosition(position)
                selectedItems[2] = selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinMaterial.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                selectedItems[3] = selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        spinSampleSize.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                selectedItems[4] = selectedItem.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }


        //https://www.youtube.com/watch?v=0wZwLfmVTvU&ab_channel=CodeWithMazn
        var selectedTime: Int = 0
        val reservationTimeBar = findViewById<SeekBar>(R.id.SB_time_bar)
        val selectedTimeNumber = findViewById<TextView>(R.id.tv_reservation_time_number)
        reservationTimeBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                selectedTime = (reservationTimeBar.progress * 15)
                selectedTimeNumber.text = "${selectedTime} minutes"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // selectedTimeNumber.text = "${selectedTime} minutes"
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })


        val reservationButton: Button = findViewById(R.id.btn_reservation)

        reservationButton.setOnClickListener {

            if (selectedItems[0].contains("Please")
                or selectedItems[1].contains("Please")
                or selectedItems[2].contains("Please")
                or selectedItems[3].contains("Please")
                or selectedItems[4].contains("Please")
            ) {

                Toast.makeText(this, "Please select all options", Toast.LENGTH_LONG).show()
            } else {
                // TODO: Tady bude logika, co sa stane ked stlaci user tlacitko make reservation a bude mat vybrane vsetky policka
                // To znamena, ze tady musi byt odeslat request na booking system s querry pozadavkama z selected items (equip cislo, a potom podla API co tam bude pan Kolaska chcet


                val researchGroup = intent.getStringExtra("EXTRA_RESEARCH_GROUP")
                val realisedFor = intent.getStringExtra("EXTRA_USER_ID")


                makeReservation(
                    context = this,
                    reservationLength = selectedTime,
                    equipment = listOf(selectedItems[0]),
                    researchGroup,
                    realisedFor,
                    1,
                    4,
                    "Operations: ${selectedItems[1]},\n" +
                            "Additional Layer: ${selectedItems[2]},\n" +
                            "Sample material: ${selectedItems[3]},\n" +
                            "Sample size: ${selectedItems[4]}"
                )

                val logOffBtn: Button = findViewById(R.id.btn_log_off)
                logOffBtn.setOnClickListener {
                    finish()
                    val intent = Intent(this, ScanCard::class.java)
                    startActivity(intent)
                    overridePendingTransition(0,1)
                }

/*
                Toast.makeText(
                    this,
                    ("Creating reservation: ${selectedItems[0]}, ${selectedItems[1]}, ${selectedItems[2]}, ${selectedItems[3]}, ${selectedItems[4]}"),
                    Toast.LENGTH_LONG
                ).show()

 */
            }
        }
    }
}