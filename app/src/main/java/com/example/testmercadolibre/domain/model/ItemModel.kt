package com.example.testmercadolibre.domain.model

data class ItemModel (
    val title :String,
    val price : PriceModel,
    val discount: DiscountModel,
    val picture: PictureURLModel
)