package com.example.testmercadolibre.data.repository

import com.example.testmercadolibre.common.toDomainModel
import com.example.testmercadolibre.data.network.ApiService
import com.example.testmercadolibre.domain.model.DetailProductDomainModel
import com.example.testmercadolibre.domain.model.SearchDomainModel
import com.example.testmercadolibre.domain.model.TokenResponseDomainModel
import com.example.testmercadolibre.domain.repository.Repository
import javax.inject.Inject


class RepositoryImpl @Inject constructor(private val apiService: ApiService) : Repository {

    override suspend fun getSearch(query: String): SearchDomainModel {
        return apiService.getSearch(query).toDomainModel()
    }

    override suspend fun getItem(id: String): DetailProductDomainModel {
        return apiService.getItem(id).toDomainModel()
    }

    override suspend fun refreshToken(
        grantType: String,
        clientId: String,
        clientSecret: String,
        refreshToken: String
    ): TokenResponseDomainModel {
        return apiService.refreshToken(grantType, clientId, clientSecret, refreshToken)
            .toDomainModel()
    }

}