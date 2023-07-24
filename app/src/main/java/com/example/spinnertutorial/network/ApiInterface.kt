package com.example.spinnertutorial.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/*In ApiInterface interface, we declare all the REST request methods with individual paths for the endpoint.
Although example is shown for a typical POST call, we can use any REST methods on our own i.e. POST, GET, PUT, DELETE etc.*/



interface ApiInterface {


    @Headers("Content-Type: application/json")
    @POST ("get-contact-by-rfid")
    fun sendCRMRequest (@Body requestModel: CRMRequestModel): Call<CRMResponseList>

    @Headers ("Auth-Token: $token")
    @POST ("api-public/service-appointment/")
    fun sendBookingRequest (@Body requestModel: BookingRequestModel): Call<BookingResponse>

}

