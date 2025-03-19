package com.example.testmercadolibre.data.network

import com.example.testmercadolibre.data.model.DetailProductDTO
import com.example.testmercadolibre.data.model.SearchDTO
import com.example.testmercadolibre.data.model.TokenResponseDTO
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/sites/MCO/search?")
    suspend fun getSearch(@Query("q") query: String): SearchDTO

    @GET("/items/{id}")
    suspend fun getItem(@Path("id") id: String): DetailProductDTO

    @FormUrlEncoded
    @POST("/oauth/token")
    suspend fun refreshToken(
        @Field("grant_type") grantType: String,
        @Field("client_id") clientId: String,
        @Field("client_secret") clientSecret: String,
        @Field("refresh_token") refreshToken: String,
    ): TokenResponseDTO
}