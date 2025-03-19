package com.example.testmercadolibre.domain.repository

import com.example.testmercadolibre.data.model.TokenResponseDTO
import com.example.testmercadolibre.domain.model.DetailProductDomainModel
import com.example.testmercadolibre.domain.model.SearchDomainModel
import com.example.testmercadolibre.domain.model.TokenResponseDomainModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Repository {

    suspend fun getSearch(query: String): SearchDomainModel

    suspend fun getItem(id: String): DetailProductDomainModel

    suspend fun refreshToken(
        grantType: String,
        clientId: String,
        clientSecret: String,
        refreshToken: String
    ): TokenResponseDomainModel
}