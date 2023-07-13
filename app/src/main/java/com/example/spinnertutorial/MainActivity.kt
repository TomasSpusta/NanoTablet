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

        binding.btnInstruments.setOnClickListener {
            replaceFragment(InstrumentsFrag(), this)
            ClearVariables()
            prepareMenu(MenuFrag(), this)
        }

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



*/