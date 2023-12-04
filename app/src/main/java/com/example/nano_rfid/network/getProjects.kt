package com.example.nano_rfid.network

import android.util.Log
import com.example.nano_rfid.Global
import com.example.nano_rfid.Global.projects
import com.example.nano_rfid.lists.ProjectItem
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

fun getProjects(userID: String) {

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

        try {
            val json = apiResponseBody?.let { it1 -> JSONObject(it1) }
            val keys: Iterator<*> = json!!.keys()
            val projectList = mutableListOf<String>()

            while (keys.hasNext()) {
                val projectGUID = keys.next() as String
                //Log.i("Projects name", projectGUID.toString())
                val projectName: String = json.getJSONObject(projectGUID).get("psa_name").toString()
                //Log.i("Projects", projectName.toString())
                projects.add(listProjectItem(projectName, projectGUID))
            }
            Log.i("Projects", projects.toString())

        } catch (e: Exception) {
            Log.i("Projects E", e.toString())
        }
    }
}

fun listProjectItem(projectName: String, projectGUID: String): ProjectItem {
    return ProjectItem(projectName, projectGUID)
}
