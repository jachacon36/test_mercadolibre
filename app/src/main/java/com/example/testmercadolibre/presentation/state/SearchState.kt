package com.example.testmercadolibre.presentation.state

import com.example.testmercadolibre.domain.model.SearchDomainModel

data class SearchState(
    val isLoading: Boolean = false,
    val data: SearchDomainModel? = null,
    var error: Boolean = false
)