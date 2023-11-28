package com.example.nano_rfid.network


import android.util.Log
import com.example.nano_rfid.Global.loadedTokenString
import com.example.nano_rfid.Global.menuFields
import com.example.nano_rfid.Global.subMenuFields
import com.example.nano_rfid.lists.MenuItem
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject

fun GetUserFields(instrumentGUID: String) {
    val logTAG = "UserFields"


    //val URL = "https://booking-beta2.ceitec.cz/api-public/equipment/$instrumentGUID/userfield-definitions"
    //val URL = "https://booking.ceitec.cz/api-public/equipment/$instrumentGUID/userfield-definitions"

    val URL = "https://booking.ceitec.cz/api/equipment/$instrumentGUID/userfield-definitions"
    try {
        if (URL.isNotEmpty()) {
            // create the HTTp client
            val fieldsFetch = OkHttpClient()
            // Build a request
            val request = Request.Builder().url(URL).header("Authorization", "Bearer $loadedTokenString").build()
            // Execute the request
            val response = fieldsFetch.newCall(request).execute()
            val body = response.body?.string()
            val bodyJsonArray = JSONArray(body)
            val fieldsBlocks = bodyJsonArray.length()
            //Log.i("$logTAG fieldsCount", fieldsCount.toString())
            subMenuFields = mutableListOf()
            menuFields = mutableListOf()

            for (block in 0..<fieldsBlocks) {
                val dataBlock = bodyJsonArray.get(block).toString()
                val json = JSONObject(dataBlock)//.get("new_note_en")
                // english name of field
                val fieldName = JSONObject(dataBlock).get("new_name_en").toString()
                //get type of the field - see https://booking-beta2.ceitec.cz/docs/api-public/
                val fieldType: Int = JSONObject(dataBlock).get("ge_type") as Int
                // get id of the field
                val fieldGUID = JSONObject(dataBlock).get("id").toString()

               //Log.i("$logTAG json", json.toString())
                //Log.i("$logTAG fields", menuField)

                menuFields.add(createMenuItem(fieldGUID, fieldName, fieldType))

                when (fieldType) {
                    200000000 -> subMenuFields.add(mutableListOf()) // text -> fragment musi byt edit text
                    200000001 -> subMenuFields.add(mutableListOf()) // number ->
                    200000002 -> subMenuFields.add(mutableListOf()) // checkbox ->
                    200000003 -> subMenuFields.add(mutableListOf()) // date ->
                    200000004 -> saveToList(json) // select box -> fragment select one
                    200000005 -> subMenuFields.add(mutableListOf()) // description -> fragment text field
                    200000006 -> subMenuFields.add(mutableListOf()) // file input -> fragment upload file
                    200000007 -> subMenuFields.add(mutableListOf()) // text area -> fragment bude jak text
                    200000008 -> subMenuFields.add(mutableListOf()) // multi-select box -> fragment multi check box
                }
            }
            Log.i("$logTAG menu", menuFields.toString())
            Log.i("$logTAG submenu", subMenuFields.toString())
        }
    } catch (e: Exception) {
        Log.i("$logTAG parceling json E", e.toString())
        Log.i("$logTAG parceling json E", e.printStackTrace().toString())
    }
}

private fun createMenuItem(fieldGUID: String, fieldName: String, fieldType: Int): MenuItem {
    val item = MenuItem(fieldName, fieldGUID, fieldType)
    return item
}

private fun saveToList(json: JSONObject) {
    val procedureOption: String = json.get("new_note_en").toString()
    val procedureList: MutableList<String> = procedureOption.split(",").toList() as MutableList<String>
    subMenuFields.add(procedureList)
}


