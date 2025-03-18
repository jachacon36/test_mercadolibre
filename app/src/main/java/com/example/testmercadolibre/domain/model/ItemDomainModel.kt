package com.example.testmercadolibre.domain.model

data class ItemDomainModel (
    val title :String,
    val price : PriceDomainModel,
    val discount: DiscountDomainModel,
    val picture: PictureURLDomainModel
)