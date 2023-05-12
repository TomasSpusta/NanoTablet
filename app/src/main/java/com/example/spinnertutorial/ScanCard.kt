package com.example.spinnertutorial

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.webkit.WebView
import android.widget.EditText
import android.widget.TextView
import com.example.spinnertutorial.network.CRMReqM


import com.example.spinnertutorial.network.RestApiManager


class ScanCard : AppCompatActivity() {

    // VARIABLES
    lateinit var myEditText: EditText
    var cardID: String = ""
    lateinit var showCardID: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_card)

        val myWeb = findViewById<WebView>(R.id.wv_booking)
        setupWebView(myWeb)

        showCardID = findViewById(R.id.tv_card_info)
        myEditText = findViewById(R.id.et_cardID)
        //myEditText.showSoftInputOnFocus = false

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
        val userInfo = CRMReqM(
            rfid = cardID
            //rfid = "1834257108"
        )
        apiService.CRMRequest(userInfo) { it ->
            if (it != null) {
                if (it.size != 0) {
                    showCardID.text = it[0].userFirstName
                    //Toast.makeText(this, it[0].userFirstName, Toast.LENGTH_SHORT).show()
                    Log.d("Response_","${it[0].userFirstName}")

                    val researchGroup: String? = it[0].primaryRg
                    val userID: String? = it[0].userID

                    val intent = Intent (this, MainActivity::class.java).also {
                        it.putExtra("EXTRA_RESEARCH_GROUP", researchGroup)
                        it.putExtra("EXTRA_USER_ID", userID)

                    }
                    startActivity(intent)


                }else{
                    showCardID.text = "Problemek s kartou visit user office"
                    //Toast.makeText(this, "Problem s kartou", Toast.LENGTH_SHORT).show()
                    Log.d("Response_","Problem s kartou")
                }
                }

            }
        }


    }


