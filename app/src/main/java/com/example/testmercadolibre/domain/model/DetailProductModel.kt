package com.example.testmercadolibre.domain.model
data class DetailProductModel (
    val title :String,
    val price : Long,
    val initial_quantity: Int = 0,
    val available_quantity: Int =0,
    val condition: String,
    val pictures: List<PictureURLModel>,
    val shipping : ShippingModel
)