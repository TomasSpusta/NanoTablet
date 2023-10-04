package com.example.nano_rfid


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nano_rfid.Global.fieldsJSON
import com.example.nano_rfid.Global.instrumentJSON
import com.example.nano_rfid.Global.reservationJSON
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.Global.userJSON
import com.example.nano_rfid.network.CRMRequestModel
import com.example.nano_rfid.network.RestApiManager
import com.google.android.material.internal.ViewUtils.hideKeyboard


class ScanCard : AppCompatActivity() {

    // VARIABLES
    lateinit var myEditText: EditText
    var cardID: String = ""
//    lateinit var showCardID: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_card)

        //  reservationJSON.put("User", userJSON)
        // reservationJSON.put("Instrument", instrumentJSON)
        //reservationJSON.put("Fields", fieldsJSON)

        val myWeb = findViewById<WebView>(R.id.wv_booking)
        //setupWebView(myWeb)


        myEditText = findViewById(R.id.et_cardID)
        myEditText.showSoftInputOnFocus = false
        myEditText.requestFocus()

        // waiting for card scan
        enterPress(myEditText)


    }


    private fun enterPress(editText: EditText) {

        editText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                cardID = editText.text.toString()

                //Toast.makeText(this, "Pressed second enter, Card ID: $cardID", Toast.LENGTH_SHORT).show()
                getUserData(cardID)
                editText.text.clear()

                return@OnKeyListener true
            }
            false
        })

    }

    private fun getUserData(cardID: String) {
        val apiService = RestApiManager()
        val userInfo = CRMRequestModel(
            rfid = cardID
            // rfid = "1834257108"
        )

        apiService.CRMRequest(userInfo) { it ->
            if (it != null) {
                if (it.size != 0) {

                    val intent = Intent(this, MainActivity::class.java)
                    //showCardID.text = it[0].userFirstName
                    //Toast.makeText(this, it[0].userFirstName, Toast.LENGTH_SHORT).show()
                    Log.i("CRM_Resp_user", reservationMap.toString())
                    //Log.d("CRM_Resp", "${it[0].userFirstName}")

                    reservationMap["User"]!!["ID"] = it[0].userID.toString()
                    reservationMap["User"]!!["Research group"] = it[0].primaryRg.toString()
                    reservationMap["User"]!!["Name"] = it[0].userFull_Name.toString()

                    Log.i("CRM_Resp_user", reservationMap.toString())


                    //userJSON.put("ID", it[0].userID.toString())
                    //userJSON.put("Research group", it[0].primaryRg.toString())
                    //userJSON.put("User name", it[0].userFull_Name.toString())

                    //Log.i("CRM_Resp_user_json", reservationJSON.toString())
                    /* val researchGroup: String? = it[0].primaryRg
                     val userID: String? = it[0].userID

                     */


                    startActivity(intent)


                } else {
                    //showCardID.text = "Problemek s kartou visit user office"
                    Toast.makeText(this, "Please scan card again", Toast.LENGTH_LONG).show()
                    Log.d("CRM card", "Problem s kartou")
                }
            } else {// response from CRM has no body
                Toast.makeText(this, "Problem s kartou, CRM, or both", Toast.LENGTH_LONG).show()
                Log.d("Response CRM", "Problem s kartou")
            }
        }
    }
}






