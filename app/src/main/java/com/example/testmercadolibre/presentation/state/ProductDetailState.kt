package com.example.testmercadolibre.presentation.state

import com.example.testmercadolibre.domain.model.DetailProductDomainModel

data class ProductDetailState(
    val isLoading: Boolean = false,
    val data: DetailProductDomainModel? = null,
    var error: String = ""
)