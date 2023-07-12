package com.example.spinnertutorial


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.spinnertutorial.databinding.ActivityMainBinding
import com.example.spinnertutorial.fragments.InfoFrag
import com.example.spinnertutorial.fragments.InstrumentsFrag

import com.example.spinnertutorial.fragments.MenuFrag
import com.example.spinnertutorial.fragments.SharedViewModel
import com.example.spinnertutorial.network.GetUserFields
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


// Tutorial podla ktereho idem:
//https://www.geeksforgeeks.org/shared-viewmodel-in-android/

class MainActivity : AppCompatActivity() {

    //binding of activity_main.xml
    private lateinit var binding: ActivityMainBinding


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate binding of activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(InfoFrag(), this)

        //val model = ViewModelProvider(this)[SharedViewModel::class.java]
        /*model.selectedItem.observe(this, Observer { data ->
            when (data) {
                0 -> replaceFragment(InstrumentsFrag())
            }
        })

         */


        //set onClickListeners for buttons to replace fragments
        binding.btnInstruments.setOnClickListener {

            replaceFragment(InstrumentsFrag(), this)
            ClearVariables()
            prepareMenu(MenuFrag(), this)
        }
        /*


                binding.btnOperations.setOnClickListener {
                    replaceFragment(OperationsFragAlt())
                }
                // TODO: tady bude fce, kdtera bude rozhodovat, co bude viditelne a co ne
                binding.btnMaterials.setOnClickListener {
                    replaceFragment(MaterialsFrag())
                }
                binding.btnLayers.setOnClickListener {
                    replaceFragment(LayersFrag())
                }
                binding.btnSizes.setOnClickListener {
                    replaceFragment(ZeroFrag())
                }

                binding.btnTime.setOnClickListener {
                    replaceFragment(TimeFrag())
                }
        */
        binding.btnReservation.setOnClickListener {
            //prepareReservation(model, binding)
            //TODO: Alert dialog -> Are you sure to make reservation? YES/NO
            //TODO: YES -> make reservation, NO -> back to selection
            ClearVariables()

        }
        binding.btnLogOff.setOnClickListener {
            finish()
            val intent = Intent(this, ScanCard::class.java)
            startActivity(intent)
            overridePendingTransition(0, 1)

        }


        // Web view will display web site of cf nano to see reservations
        // setupWebView(myWeb)

        // Set up spinner for equip, operations...
        // setupSpinner()

        // Checking the selected time of reservation
        // checkTime()
        //println (map.toString())

    }


}







/*
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


 */
/*

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
                    reservationLength = 60,
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

*/