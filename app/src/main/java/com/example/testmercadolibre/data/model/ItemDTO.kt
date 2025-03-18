package com.example.testmercadolibre.data.model

data class ItemDTO (
    val title :String,
    val price : PriceDTO,
    val discount: DiscountDTO,
    val picture: PictureURLDTO
)