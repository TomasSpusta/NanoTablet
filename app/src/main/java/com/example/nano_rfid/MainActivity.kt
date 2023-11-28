package com.example.nano_rfid


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.databinding.ActivityMainBinding
import com.example.nano_rfid.fragments.InfoFrag
import com.example.nano_rfid.fragments.InstrumentsFrag
import com.example.nano_rfid.fragments.MenuFrag
import com.example.nano_rfid.fragments.ResInfoFrag
import com.example.nano_rfid.fragments.TimeFrag
import com.example.nano_rfid.network.GetUserFields
import com.example.nano_rfid.network.loadToken
import com.example.nano_rfid.network.verifyToken
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


// Tutorial podla ktereho idem:
//https://www.geeksforgeeks.org/shared-viewmodel-in-android/

class MainActivity : AppCompatActivity() {

    //binding of activity_main.xml
    private lateinit var binding: ActivityMainBinding

    // Inactivity
    // Declaring handler, runnable and time in milli seconds
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private var mTime: Long = 300 * 1000 // time of inactivity in milliseconds => seconds*1000

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //loadToken(applicationContext)
        //verify token, if it is valid
        GlobalScope.launch {
            Log.i("token", "Checking token")
            loadToken(applicationContext)
            verifyToken(applicationContext)
            Log.i("token", Global.loadedTokenString)
        }



        //inflate binding of activity_main.xml
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initializing the handler and the runnable
        //mHandler = Handler(Looper.getMainLooper())
        /*
        mRunnable = Runnable {

            Toast.makeText(applicationContext, "User inactive for ${mTime / 60 / 1000} minutes! Logging off.", Toast.LENGTH_LONG).show()
            logOff()

        }

         */

        // Start the handler
        //startHandler()



        // Open Info fragment -> Information how to use the app will be showed
        //replaceFragment(InfoFrag(), this) // --> info frag is not necessary
        replaceFragment(InstrumentsFrag(), this)

        // display logged user name and number in left top corner
        binding.tvUser.text = reservationMap["User"]!!["Name"]

        // selection of instruments after taping the button
        binding.btnInstruments.setOnClickListener {
            // display instrument fragment
            replaceFragment(InstrumentsFrag(), this)
            // clear variables stored in reservationMap
            clearFields()
            reloadInfo(ResInfoFrag(), this)
            //Log.i("Res map", reservationMap.toString())
            // prepare menu (left fragment) according to the selected instrument
            prepareMenu(MenuFrag(), this)

        }

        // make reservation when button is pressed
        binding.btnReservation.setOnClickListener {
            makeReservation(this)
            // display instrument fragment
            replaceFragment(InstrumentsFrag(), this)
            clearFields()
            reloadInfo(ResInfoFrag(), this)
            prepareMenu(MenuFrag(), this)
        }

// clear variables and restart application -> display scan card page
        binding.btnLogOff.setOnClickListener {
            // clear variables when user is logged off
            logOff()

        }

        // show Time fragment -> select time of reservation
        binding.btnTime.setOnClickListener {
            replaceFragment(TimeFrag(), this)
        }
    }

    // When the screen is touched or motion is detected
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        // Removes the handler callbacks (if any)
        stopHandler()

        // Runs the handler (for the specified time)
        // If any touch or motion is detected before
        // the specified time, this override function is again called
        startHandler()

        return super.onTouchEvent(event)
    }


    private fun logOff() {
        clearVariables()
        finish()
        val intent = Intent(this, ScanCard::class.java)
        startActivity(intent)
        overridePendingTransition(0, 1)
        Log.i("CRM_Resp_user", reservationMap.toString())
    }


    // start handler function
    private fun startHandler() {
        mHandler.postDelayed(mRunnable, mTime)
    }

    // stop handler function
    private fun stopHandler() {
        mHandler.removeCallbacks(mRunnable)
    }
}