package com.example.nano_rfid.network

import com.example.nano_rfid.Global.loadedTokenString
import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization","Bearer $loadedTokenString")
            .build()
        return chain.proceed(request)
    }
}