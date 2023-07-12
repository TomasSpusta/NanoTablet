package com.example.spinnertutorial.network

import android.util.Log
import com.example.spinnertutorial.Global.fieldsOptions
import com.example.spinnertutorial.Global.userFieldsGUIDs
import com.example.spinnertutorial.Global.userFieldsNames
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.lang.Exception

fun GetUserFields(instrumentGUID: String) {

    val URL = "https://booking-beta2.ceitec.cz/api-public/equipment/$instrumentGUID/userfield-definitions"

    if (URL.isNotEmpty()) {
        // create the HTTp client
        val fieldsFetch = OkHttpClient()
        // Build a request
        val request = Request.Builder().url(URL).build()
        // Execute the request
        val response = fieldsFetch.newCall(request).execute()
        val body = response.body?.string()
        Log.i("Response", body.toString())

        try {
            val json = body?.let { it1 -> JSONObject(it1) }
            //https://stackoverflow.com/questions/58936702/how-can-i-parse-nested-json-with-dynamic-keys-in-android-kotlin-moshi-and-retro
            //
            val fields: Iterator<*> = json!!.keys()
            // create empty lists, to clear main activity after pressing instrument button
            userFieldsGUIDs = mutableListOf()
            userFieldsNames = mutableListOf()
            fieldsOptions = mutableListOf()
            // loop through keys (fields) - save their GUIDs, names and submenus
            while (fields.hasNext()) {
                //input field
                val field = fields.next() as String
                // save field GUID to list
                userFieldsGUIDs.add(field)
                // english name of field
                val fieldName: String = json.getJSONObject(field).get("new_name_en").toString()
                // save field name to list
                userFieldsNames.add(fieldName)

                //get type of the field - see https://booking-beta2.ceitec.cz/docs/api-public/
                val type: Int = json.getJSONObject(field).get("ge_type") as Int
                // if type "0" - text box, create empty list
                if (type == 200000000) {
                    Log.i("Resp type", "type is text")
                    fieldsOptions.add(mutableListOf())
                }
                if (type == 200000001) {
                    Log.i("Resp type", "type is number")
                    fieldsOptions.add(mutableListOf())

                } else {
                    // else add procedures to fieldsOptions list
                    val procedureOption: String = json.getJSONObject(field).get("new_note_en").toString()
                    val procedureList: MutableList<String> = procedureOption.split(", ").toList() as MutableList<String>
                    fieldsOptions.add(procedureList)
                }
            }
            Log.i("Resp field codes", userFieldsGUIDs.toString())
            Log.i("Resp field names", userFieldsNames.toString())
            Log.i("Resp field options", fieldsOptions.toString())

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}