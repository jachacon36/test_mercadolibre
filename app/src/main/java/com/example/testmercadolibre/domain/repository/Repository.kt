package com.example.testmercadolibre.domain.repository

import com.example.testmercadolibre.domain.model.DetailProductDomainModel
import com.example.testmercadolibre.domain.model.SearchDomainModel

interface Repository {

    suspend fun getSearch(query: String): SearchDomainModel

    suspend fun getItem(id: String): DetailProductDomainModel

}