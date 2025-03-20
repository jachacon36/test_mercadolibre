package com.example.testmercadolibre.presentation.state

import com.example.testmercadolibre.domain.model.ComponentDomainModel

data class HomeState(
    val isLoading: Boolean = false,
    val data: List<ComponentDomainModel>? = null,
    var error: Boolean = false
)