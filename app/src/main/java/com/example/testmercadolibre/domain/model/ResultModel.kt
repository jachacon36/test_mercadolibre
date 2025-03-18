package com.example.testmercadolibre.domain.model

data class ResultModel (
    val id : String,
    val title : String,
    val price: String,
    val thumbnail: String,
    val installments : InstallmentsModel?,
    val shipping: ShippingModel
)