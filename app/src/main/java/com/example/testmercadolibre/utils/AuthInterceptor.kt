package com.example.testmercadolibre.utils

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer APP_USR-140881273972308-031813-2152da3c0d0842bb65ae9615023e6b01-322906081")
            .build()
        return chain.proceed(request)
    }
}