package com.example.nano_rfid.network

import android.content.Context
import android.util.Log
import com.example.nano_rfid.Global
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

fun getProjects(userID:String) {

    val URL = "https://booking.ceitec.cz/api/contact/$userID/projects"

    if (URL.isNotEmpty()) {
        // create the HTTp client
        val client = OkHttpClient()
        // Build a request
        val request = Request.Builder()
            .url(URL)
            .header("Authorization", "Bearer ${Global.loadedTokenString}")
            .build()
        // Execute the request
        val apiResponse = client.newCall(request).execute()

        val apiResponseBody = apiResponse.body?.string()
        if (apiResponseBody != null) {

            val projects = mutableListOf<String>()
            val keys = JSONObject (apiResponseBody).keys().asSequence().toList()
            /*keys.forEach( project ->
            Log.i("Projects list", keys.toString())
            )*/


            Log.i("Projects list", keys.toString())

        }
    }
}