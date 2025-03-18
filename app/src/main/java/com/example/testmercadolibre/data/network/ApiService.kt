package com.example.testmercadolibre.data.network

import com.example.testmercadolibre.data.model.DetailProductDTO
import com.example.testmercadolibre.data.model.SearchDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/sites/MCO/search?")
    suspend fun getSearch(@Query("q") query: String): SearchDTO

    @GET("/items/{id}")
    suspend fun getItem(@Path("id") id: String): DetailProductDTO

}