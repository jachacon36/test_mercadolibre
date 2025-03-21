package com.example.testmercadolibre.domain.repository

import com.example.testmercadolibre.domain.model.ComponetsJSONDomainModel
import com.example.testmercadolibre.domain.model.DetailProductDomainModel
import com.example.testmercadolibre.domain.model.SearchDomainModel
import com.example.testmercadolibre.domain.model.TokenResponseDomainModel

interface Repository {

    suspend fun getSearch(query: String): SearchDomainModel

    suspend fun getItem(id: String): DetailProductDomainModel

    suspend fun refreshToken(
        grantType: String,
        clientId: String,
        clientSecret: String,
        refreshToken: String
    ): TokenResponseDomainModel

    suspend fun getHome(): ComponetsJSONDomainModel
}