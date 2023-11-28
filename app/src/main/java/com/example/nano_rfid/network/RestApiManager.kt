package com.example.nano_rfid.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*Finally, we implement the actual Service which we will directly invoke.
We call it service but don’t be confused with Android service.
If you feel you can rename the class as your own like with RestApiManager or ApiManager etc.*/


class RestApiManager {

    fun CRMRequest(requestModel: CRMRequestModel, onResult: (CRMResponseList?) -> Unit) {

        val retrofit = CRMServiceBuilder.buildService(ApiInterface::class.java)
        retrofit.sendCRMRequest(requestModel).enqueue(

            object : Callback<CRMResponseList> {

                override fun onFailure(call: Call<CRMResponseList>, t: Throwable) {
                    onResult(null)
                    Log.d("CRM_onFailure", "Nepodarilo sa spojit s CRM")
                }

                override fun onResponse(call: Call<CRMResponseList>, response: Response<CRMResponseList>) {
                    val cRMResponse = response.body()
                    onResult(cRMResponse)

                }
            }
        )
    }

    fun BookingRequest(requestModel: BookingRequestModel, onResult: (BookingResponse?) -> Unit) {
        val retrofit = BookingServiceBuilder.buildService(ApiInterface::class.java)
        retrofit.sendBookingRequest(requestModel).enqueue(

            object : Callback<BookingResponse> {

                override fun onFailure(call: Call<BookingResponse>, t: Throwable) {
                    onResult(null)
                    Log.d("Booking_Resp_fail", onResult.toString())

                }

                override fun onResponse(call: Call<BookingResponse>, response: Response<BookingResponse>) {
                    val bookingResponse = response.body()
                    onResult(bookingResponse)

                    Log.d("Booking_Resp_code", "${response.code()}")
                    Log.d("Booking_Resp_body", "${response.body()}")
                    Log.d("Booking_Resp", "${response.toString()}")
                    Log.d("Booking_Resp_message", "${response.message()}")
                    Log.d("Booking_Resp_message", "${response.raw()}")


                }
            }
        )
    }
}