package com.example.spinnertutorial

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.spinnertutorial.Global.reservationMap
import com.example.spinnertutorial.Global.selectedTime
import com.example.spinnertutorial.network.BookingRequestModel
import com.example.spinnertutorial.network.RestApiManager
import org.json.JSONObject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun makeReservation(
    context: Context

) {

    val timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val startTime = LocalDateTime.now().format(timeFormat)
    val reservationLengthLong = selectedTime.toLong() // selected time of reservation
    val endTime = reservationLengthLong.let { LocalDateTime.now().plusMinutes(it).format(timeFormat) }

    val apiService = RestApiManager()

    val reservationInfo = BookingRequestModel(
        timeFrom = startTime,
        timeTo = endTime,
        equipment = listOf(reservationMap["Instrument"]!!["Instrument GUID"].toString()), //listOf("cd4d42a8-3453-e311-85a1-005056991551"),//,
        researchGroup = //reservationMap["User"]!!["Research group"].toString(),
        "77b7b68a-7efb-e711-8b1a-005056991551",
        userID = //reservationMap["User"]!!["ID"].toString(),
        "2c5c963c-68ba-e311-85a1-005056991551",
        timeRequirement = 1,
        statusCode = 4,
        description = "",
        fields = fieldsMap()//prepFieldsMap()//.toString()//prepFields().toString()//prepareFields()
    )

    Log.i("Res_Payload", reservationInfo.fields.toString())
   //fieldsMap()


    apiService.BookingRequest(reservationInfo) {
        Thread.sleep(250)
        if (it != null) {
            Toast.makeText(context, "Reservation created succesfully", Toast.LENGTH_LONG).show()
            //println(it)
            Log.d("Suc_Res_Resp", it.reservationGUID.toString())
        } else {
            Log.d("Fail_Res_Resp", "Problem s booking response")
            Toast.makeText(context, "Reservation not created! You probably do not have authorization to create reservation on selected machine", Toast.LENGTH_LONG).show()
        }


    }


}


private fun fieldsMap(): MutableMap<String, MutableMap<String, Any>> {
    //val fields = mutableMapOf<String, MutableMap<String, String>>()
    val singleField = mutableMapOf<String, Any>()
    val fieldNumber = reservationMap["Fields"]?.size?.div(3)
    for (i in 0..<fieldNumber!!) {
        singleField[reservationMap["Fields"]!!["$i GUID"].toString()] = reservationMap["Fields"]!!["$i value"].toString()
        //Log.i("Fields single", singleField.toString())
    }
    val instrumentGUID = reservationMap["Instrument"]!!["Instrument GUID"].toString()
    val fields = mutableMapOf<String, MutableMap<String, Any>>(instrumentGUID to singleField)
    val fields_E = prepFieldsMap()


    //Log.i("Fields single", singleField.toString())
    Log.i("Fields map", fields.toString())
    Log.i("Fields_E map", fields_E.toString())
    return fields
}

private fun prepFieldsMap(): MutableMap<String, MutableMap<String, String>> {
    val singleField = mutableMapOf<String, String>("0e1d7471-299b-ed11-80d3-005056914121" to "Si3N4")
    val fields = mutableMapOf<String, MutableMap<String, String>>("cd4d42a8-3453-e311-85a1-005056991551" to singleField)
    return fields
}
