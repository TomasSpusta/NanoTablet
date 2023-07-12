package com.example.spinnertutorial

import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.spinnertutorial.network.BookingReqM
import com.example.spinnertutorial.network.RestApiManager
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun makeReservation(
    context:Context,
    reservationLength: Int?,
    equipment: List<String?>,
    researchGroup: String?,
    realisedFor: String?,
    timeRequirement: Int?,
    statusCode: Int?,
    description: String?,
    fields : Map<String?,Map<String?,String?>>
) {

    val timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val startTime = LocalDateTime.now().format(timeFormat)
    val reservationLengthLong = reservationLength?.toLong()
    val endTime = reservationLengthLong?.let { LocalDateTime.now().plusMinutes(it).format(timeFormat) }

    val apiService = RestApiManager()


    val reservationInfo = BookingReqM(
        timeFrom = startTime,
        timeTo = endTime,
        equipment = equipment,
        researchGroup = researchGroup,
        userID = realisedFor,
        timeRequirement = timeRequirement,
        statusCode = statusCode,
        description = description,
        fields = fields
    )
    apiService.BookingRequest(reservationInfo) {
        if (it != null) {

            Toast.makeText(context, "Reservation created succesfully", Toast.LENGTH_LONG).show()
            //println(it)
            Log.d("Response_", it.reservationGUID.toString())


        } else {
            Log.d("Response_", "Problem s booking response")
            Toast.makeText(context, "Reservation not created! You probably do not have authorization to create reservation on selected machine", Toast.LENGTH_LONG).show()
        }
    }
}
