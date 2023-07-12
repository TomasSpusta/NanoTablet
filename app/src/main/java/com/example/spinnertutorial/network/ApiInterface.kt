package com.example.spinnertutorial.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

/*In ApiInterface interface, we declare all the REST request methods with individual paths for the endpoint.
Although example is shown for a typical POST call, we can use any REST methods on our own i.e. POST, GET, PUT, DELETE etc.*/



interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST ("get-contact-by-rfid")
    fun sendCRMReq (@Body requestModel: CRMReqM): Call<CRMResMList>

    @Headers ("Auth-Token: 4fe14cb3f9058e3146f76474b81e199d")
    @POST ("api-public/service-appointment/")
    fun sendBookingReq (@Body requestModel: BookingReqM): Call<BookingResM>

}

