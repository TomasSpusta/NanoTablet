package com.example.spinnertutorial.network

import android.util.Log
import com.example.spinnertutorial.Global.menuFields
import com.example.spinnertutorial.Global.subMenuFields
import com.example.spinnertutorial.lists.MenuItem
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

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
        //Log.i("Response", body.toString())

        try {
            val json = body?.let { it1 -> JSONObject(it1) }
            //https://stackoverflow.com/questions/58936702/how-can-i-parse-nested-json-with-dynamic-keys-in-android-kotlin-moshi-and-retro
            //
            val fields: Iterator<*> = json!!.keys()
            // create empty lists, to clear main activity after pressing instrument button
            subMenuFields = mutableListOf()
            menuFields = mutableListOf()

            // loop through keys (fields) - save their GUIDs, names and submenus
            while (fields.hasNext()) {
                //input field
                val fieldGUID = fields.next() as String

                // english name of field
                val fieldName: String = json.getJSONObject(fieldGUID).get("new_name_en").toString()

                //get type of the field - see https://booking-beta2.ceitec.cz/docs/api-public/
                val fieldType: Int = json.getJSONObject(fieldGUID).get("ge_type") as Int

                when (fieldType) {
                    200000000 -> subMenuFields.add(mutableListOf()) // text -> fragment musi byt edit text
                    200000001 -> subMenuFields.add(mutableListOf()) // number ->
                    200000002 -> subMenuFields.add(mutableListOf()) // checkbox ->
                    200000003 -> subMenuFields.add(mutableListOf()) // date ->
                    200000004 -> saveToList(json, fieldGUID) // select box -> fragment select one
                    200000005 -> subMenuFields.add(mutableListOf()) // description -> fragment text field
                    200000006 -> subMenuFields.add(mutableListOf()) // file input -> fragment upload file
                    200000007 -> subMenuFields.add(mutableListOf()) // text area -> fragment bude jak text
                    200000008 -> subMenuFields.add(mutableListOf()) // multi-select box -> fragment multi check box
                }

                menuFields.add(createMenuItem(fieldGUID, fieldName, fieldType))
            }
            //Log.i("Resp field codes", userFieldsGUIDs.toString())
            //Log.i("Resp field names", userFieldsNames.toString())
            //Log.i("Resp sub menu fields", subMenuFields.toString())
            Log.i("Resp menu fields", menuFields.toString())

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

private fun createMenuItem(fieldGUID: String, fieldName: String, fieldType: Int): MenuItem {
    val item = MenuItem(fieldName, fieldGUID, fieldType)
    return item
}

private fun saveToList(json: JSONObject, fieldGUID: String) {
    val procedureOption: String = json.getJSONObject(fieldGUID).get("new_note_en").toString()
    val procedureList: MutableList<String> = procedureOption.split(",").toList() as MutableList<String>
    subMenuFields.add(procedureList)
}