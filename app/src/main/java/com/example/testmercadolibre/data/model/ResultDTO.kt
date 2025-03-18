package com.example.testmercadolibre.data.model

data class ResultDTO (
    val id : String,
    val title : String,
    val price: String,
    val thumbnail: String,
    val installments : InstallmentsDTO?,
    val shipping: ShippingDTO
)