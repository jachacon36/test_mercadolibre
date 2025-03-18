package com.example.testmercadolibre.domain.model

data class ResultDomainModel (
    val id : String,
    val title : String,
    val price: String,
    val thumbnail: String,
    val installments : InstallmentsDomainModel?,
    val shipping: ShippingDomainModel
)