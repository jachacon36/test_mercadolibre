package com.example.testmercadolibre.data.model
data class DetailProductDTO (
    val title :String,
    val price : Long,
    val initial_quantity: Int = 0,
    val available_quantity: Int =0,
    val condition: String,
    val pictures: List<PictureURLDTO>,
    val shipping : ShippingDTO
)