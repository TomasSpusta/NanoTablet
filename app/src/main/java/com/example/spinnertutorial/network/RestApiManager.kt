package com.example.spinnertutorial.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*Finally, we implement the actual Service which we will directly invoke.
We call it service but don’t be confused with Android service.
If you feel you can rename the class as your own like with RestApiManager or ApiManager etc.*/


class RestApiManager {

    fun CRMRequest(requestModel: CRMReqM, onResult: (CRMResMList?) -> Unit) {

        val retrofit = CRMServiceBuilder.buildService(ApiInterface::class.java)
        retrofit.sendCRMReq(requestModel).enqueue(

            object : Callback<CRMResMList> {

                override fun onFailure(call: Call<CRMResMList>, t: Throwable) {
                    onResult(null)
                    println("Problemek CRM onFailure funkce")
                }

                override fun onResponse(call: Call<CRMResMList>, response: Response<CRMResMList>) {
                    val cRMResponse = response.body()
                    onResult(cRMResponse)

                }
            }
        )
    }

    fun BookingRequest(requestModel: BookingReqM, onResult: (BookingResM?) -> Unit) {
        val retrofit = BookingServiceBuilder.buildService(ApiInterface::class.java)
        retrofit.sendBookingReq(requestModel).enqueue(

            object : Callback<BookingResM> {

                override fun onFailure(call: Call<BookingResM>, t: Throwable) {
                    onResult(null)
                    Log.d("_Response",onResult.toString())
                    println("Problemek Booking onFailure funkce")
                }

                override fun onResponse(call: Call<BookingResM>, response: Response<BookingResM>) {
                    val bookingResponse = response.body()
                    onResult(bookingResponse)


                    Log.d("_Response","${response.code()}")
                    Log.d("_Response","${response.body()}")

                }


            }
        )
    }
}