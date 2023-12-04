package com.example.nano_rfid.network

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.nano_rfid.Global
import com.example.nano_rfid.Global.loadedTokenExpiration
import com.example.nano_rfid.Global.loadedTokenString

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.time.LocalDateTime

//https://en.proft.me/2019/10/14/reading-and-writing-files-android-using-kotlin/
//https://stackoverflow.com/questions/4015773/the-method-openfileoutput-is-undefined
//https://www.baeldung.com/kotlin/read-file
//https://www.geeksforgeeks.org/read-from-files-using-inputreader-in-kotlin/


val tokenFileName = "token.txt"
val TAG = "tokenApi"


fun loadToken(context: Context) {
    try {
        val listOfLines = mutableListOf<String>()
        context.openFileInput(tokenFileName).reader().useLines { lines ->
            lines.forEach { listOfLines.add(it) }
            loadedTokenString = listOfLines[0]
            loadedTokenExpiration = listOfLines[1]
            //Log.i("$TAG load", "${loadedTokenString}\n${loadedTokenExpiration}")
            Log.i("${TAG} Load", "Token loaded")
        }

    } catch (e: Exception) {
        Log.i("${TAG} Load error", e.toString())
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun verifyToken(context: Context) {
    Log.i("$TAG verify", "Checking token")
    try {
        //val timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val timeNow = LocalDateTime.now()//.format(timeFormat)
        val tokenExpirationTime = LocalDateTime.parse(loadedTokenExpiration)
       // Log.i("$TAG timeNow", timeNow.toString())
       // Log.i("$TAG ExpTime", tokenExpirationTime.toString())
        //Log.i("$TAG time", timeNow.isAfter(tokenExpirationTime).toString())

        if (timeNow.isAfter(tokenExpirationTime)) {
            Log.i("$TAG verify", "Token is invalid")
            getNewToken(context)
            Log.i("$TAG verify", "New token created")

        } else {
            Log.i("$TAG verify", "Token is valid")
        }

    } catch (e: Exception) {
        Log.i("verifyToken error", e.toString())
    }
}


fun getNewToken(context: Context) {
    val API_key = "ude9c6nezyr71i9vf3jdtye18vwdk81s"
    val mediaType = "application/json; charset=utf-8".toMediaType()
    val apiKeyPayload = JSONObject().put("apiKey", API_key)
    val requestBody = apiKeyPayload.toString().toRequestBody(mediaType)
    val URL = "https://booking.ceitec.cz/api/login"

    if (URL.isNotEmpty()) {
        // create the HTTp client
        val client = OkHttpClient()
        // Build a request
        val request = Request.Builder()
            .url(URL)
            .post(requestBody)
            .build()
        // Execute the request
        val apiResponse = client.newCall(request).execute()

        val apiResponseBody = apiResponse.body?.string()
        if (apiResponseBody != null) {
            Log.i("$TAG + Body", apiResponseBody)
        }

        try {
            val tokenJson = apiResponseBody?.let { it1 -> JSONObject(it1) }
            val tokenString = tokenJson?.get("accessToken").toString()
            val tokenExpiration = tokenJson?.get("expiresAt").toString()

            Log.i("$TAG + Token", tokenString)
            Log.i("$TAG + Expiration", tokenExpiration)
            //Log.i("Api token string", tokenString.toString())
            val tokenFlow = "$tokenString\n$tokenExpiration"
            saveToken(context, tokenFlow)
        } catch (e: Exception) {

            Log.i("getNewToken error", e.toString())
        }
    }
}


fun saveToken(context: Context, tokenFlow: String) {
    try {
        context.openFileOutput(tokenFileName, MODE_PRIVATE).use { output ->
            output.write(tokenFlow.toByteArray())
        }
        Log.i("saveToken", "Token saved")
    } catch (e: Exception) {
        Log.i("saveToken error", e.toString())
    }
}

fun clearToken (context: Context) {
    try {
        val tokenFlow = "$loadedTokenExpiration\nx"
        context.openFileOutput(tokenFileName, MODE_PRIVATE).use { output ->
            output.write(tokenFlow.toByteArray())
        }
        Log.i("clearToken", "Token cleared")
    } catch (e: Exception) {
        Log.i("clearToken error", e.toString())
    }

}




