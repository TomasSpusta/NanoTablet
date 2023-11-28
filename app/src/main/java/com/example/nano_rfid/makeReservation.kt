package com.example.nano_rfid

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.nano_rfid.Global.reservationMap
import com.example.nano_rfid.Global.selectedTime
import com.example.nano_rfid.network.BookingRequestModel
import com.example.nano_rfid.network.RestApiManager
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun makeReservation(
    context: Context

) {
    val TAG = "makeRes"
    val timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val startTime = LocalDateTime.now().format(timeFormat)
    val reservationLengthLong = selectedTime.toLong() // selected time of reservation
    val endTime = reservationLengthLong.let { LocalDateTime.now().plusMinutes(it).format(timeFormat) }

    val apiService = RestApiManager()

    val reservationInfo = BookingRequestModel(
        timeFrom = startTime,
        timeTo = endTime,
        equipment = listOf(reservationMap["Instrument"]!!["Instrument GUID"].toString()), //listOf("cd4d42a8-3453-e311-85a1-005056991551"),//,
        researchGroup = reservationMap["User"]!!["Research group"].toString(),
        //"77b7b68a-7efb-e711-8b1a-005056991551",
        userID = reservationMap["User"]!!["ID"].toString(),
        //"2c5c963c-68ba-e311-85a1-005056991551",
        timeRequirement = 1,
        statusCode = 4,
        description = "",
        fields = fieldsMap()
    )

    Log.i("$TAG map", reservationMap.toString())

    try {


        apiService.BookingRequest(reservationInfo) {
            Thread.sleep(250)
            if (it != null) {
                Toast.makeText(context, "Reservation created successfully", Toast.LENGTH_LONG).show()
                Log.d("$TAG OK", it.reservationGUID.toString())
            } else {
                Log.d("$TAG Fail", "Problem s booking response")

                Toast.makeText(context, "Reservation not created! You probably do not have authorization to create reservation on selected machine", Toast.LENGTH_LONG).show()
            }
        }
    }catch (e:Exception){
        Log.d("$TAG ResE", e.toString())
    }
}


private fun fieldsMap(): MutableMap<String, MutableMap<String, Any>> {

    val singleField = mutableMapOf<String, Any>()
    val fieldNumber = reservationMap["Fields"]?.size?.div(3)

    for (i in 0..<fieldNumber!!) {
        singleField[reservationMap["Fields"]!!["$i GUID"].toString()] = reservationMap["Fields"]!!["$i value"].toString()
        //Log.i("Fields single", singleField.toString())
    }
    val instrumentGUID = reservationMap["Instrument"]!!["Instrument GUID"].toString()
    val fields = mutableMapOf<String, MutableMap<String, Any>>(instrumentGUID to singleField)

    //Log.i("Fields single", singleField.toString())
    Log.i("makeRes fields", fields.toString())

    return fields
}
