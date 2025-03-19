package com.example.testmercadolibre.utils

import com.example.testmercadolibre.data.network.ApiService
import com.example.testmercadolibre.utils.Constant.ACCESS_TOKEN
import com.example.testmercadolibre.utils.Constant.AUTHORIZATION
import com.example.testmercadolibre.utils.Constant.BEARER
import com.example.testmercadolibre.utils.Constant.CLIENT_ID
import com.example.testmercadolibre.utils.Constant.CLIENT_SECRET
import com.example.testmercadolibre.utils.Constant.ERROR_CODE
import com.example.testmercadolibre.utils.Constant.GRANT_TYPE
import com.example.testmercadolibre.utils.Constant.REFRESH_TOKEN
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Provider

class AuthInterceptor @Inject constructor(private val apiServiceProvider: Provider<ApiService>) :
    Interceptor {

    @Volatile
    private var accessToken: String = ACCESS_TOKEN
    private val refreshToken: String = REFRESH_TOKEN

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(AUTHORIZATION, "$BEARER $accessToken")
            .build()

        val response = chain.proceed(request)

        if (response.code == ERROR_CODE) {
            // Close the previous response
            response.close()

            synchronized(this) {
                // Refresh the token
                val newToken = runBlocking {
                    val tokenResponse = apiServiceProvider.get().refreshToken(
                        grantType = GRANT_TYPE,
                        clientId = CLIENT_ID,
                        clientSecret = CLIENT_SECRET,
                        refreshToken = refreshToken
                    )
                    tokenResponse.accessToken
                }
                accessToken = newToken

                // Retry the request with the new token
                val newRequest = chain.request().newBuilder()
                    .header(AUTHORIZATION, "$BEARER $accessToken")
                    .build()
                return chain.proceed(newRequest)
            }
        }

        return response
    }
}