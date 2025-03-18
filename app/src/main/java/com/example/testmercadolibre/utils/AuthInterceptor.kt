package com.example.testmercadolibre.utils

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer APP_USR-140881273972308-031721-86c6b9345b6258c2642d75dd45cf791c-322906081")
            .build()
        return chain.proceed(request)
    }
}