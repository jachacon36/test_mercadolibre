package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class ItemDTO (
    @SerializedName("title")
    val title :String,
    @SerializedName("price")
    val price : PriceDTO,
    @SerializedName("discount")
    val discount: DiscountDTO,
    @SerializedName("picture")
    val picture: PictureURLDTO
)