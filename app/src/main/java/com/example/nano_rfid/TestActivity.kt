package com.example.nano_rfid

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.nano_rfid.Global.loadedTokenExpiration
import com.example.nano_rfid.Global.loadedTokenString
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.network.GetUserFields
import com.example.nano_rfid.network.TAG
import com.example.nano_rfid.network.clearToken
import com.example.nano_rfid.network.getNewToken
import com.example.nano_rfid.network.getProjects
import com.example.nano_rfid.network.loadToken
import com.example.nano_rfid.network.saveToken
import com.example.nano_rfid.network.verifyToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.io.InputStream
import java.lang.Exception

class TestActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        /*
                reservationMap["User"]!!["ID"] = "2c5c963c-68ba-e311-85a1-005056991551"
                val tomID = "2c5c963c-68ba-e311-85a1-005056991551"
                loadToken(applicationContext)
                //risa guid (z bookingu): 64a015fd-f536-e611-9f54-005056991551 <-- Toto je normal user ID
                val risaID = "64a015fd-f536-e611-9f54-005056991551"
                //michal guid (z bookingu): f910daf2-b855-e211-970b-005056991551 <-- <-- Toto je normal user ID
                val michalID = "f910daf2-b855-e211-970b-005056991551"

         */
        GlobalScope.launch {
            //getNewToken(applicationContext)
            clearToken(applicationContext)

        }
        /*





                GlobalScope.launch {
                    loadToken(applicationContext)
                    verifyToken(applicationContext)
                    //Log.i("token", loadedTokenString)
                    //GetUserFields("cd4d42a8-3453-e311-85a1-005056991551")


                }




         */
    }


}
