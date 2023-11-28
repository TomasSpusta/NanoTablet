package com.example.nano_rfid.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*We create a builder of the retrofit object which can be reused
for all method calls declared in the ApiInterface interface.
We can set many properties like, converter factory for json parsing,
base url, http client and many more configurations as required.
Here is the simplest required form for our tasks.*/

const val bookingURL = "https://booking.ceitec.cz/"
const val CRMURL = "https://crm.api.ceitec.cz/"

object BookingServiceBuilder {
    private val client = OkHttpClient.Builder().apply { addInterceptor(MyInterceptor()) }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(bookingURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}

object CRMServiceBuilder {

    private val client = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(CRMURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}