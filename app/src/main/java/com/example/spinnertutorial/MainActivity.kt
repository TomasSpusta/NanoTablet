package com.example.spinnertutorial


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.databinding.ActivityMainBinding
import com.example.spinnertutorial.fragments.InfoFrag
import com.example.spinnertutorial.fragments.InstrumentsFrag
import com.example.spinnertutorial.fragments.MenuFrag
import com.example.spinnertutorial.fragments.ResInfoFrag
import com.example.spinnertutorial.fragments.TimeFrag


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

        // Open Info fragment -> Information how to use the app will be showed
        replaceFragment(InfoFrag(), this)

        // display logged user name and number in left top corner
        binding.tvUser.text = reservationMap["User"]!!["ID"]

        // selection of instruments after taping the button
        binding.btnInstruments.setOnClickListener {
            // display instrument fragment
            replaceFragment(InstrumentsFrag(), this)
            // clear variables stored in reservationMap
            ClearVariables()
            // prepare menu (left fragment) according to the selected instrument
            prepareMenu(MenuFrag(), this)
            reloadInfo(ResInfoFrag(),this)
        }

        // make reservation when button is pressed
        binding.btnReservation.setOnClickListener {
            makeReservation(this)
        }

// clear variables and restart application -> display scan card page
        binding.btnLogOff.setOnClickListener {
            // clear variables when user is logged off
            // ClearVariables()

            finish()
            val intent = Intent(this, ScanCard::class.java)
            startActivity(intent)
            overridePendingTransition(0, 1)
        }

        // show Time fragment -> select time of reservation
        binding.btnTime.setOnClickListener {
            replaceFragment(TimeFrag(), this)
        }
    }
}
