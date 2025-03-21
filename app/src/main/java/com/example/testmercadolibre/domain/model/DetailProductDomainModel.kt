package com.example.testmercadolibre.domain.model
data class DetailProductDomainModel (
    val title :String,
    val price : Long,
    val initialQuantity: Int,
    val availableQuantity: Int,
    val condition: String,
    val pictures: List<PictureURLDomainModel>,
    val shipping : ShippingDomainModel
)