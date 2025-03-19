package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class DetailProductDTO(
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Long,
    @SerializedName("initial_quantity")
    val initialQuantity: Int = 0,
    @SerializedName("available_quantity")
    val availableQuantity: Int = 0,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("pictures")
    val pictures: List<PictureURLDTO>,
    @SerializedName("shipping")
    val shipping: ShippingDTO
)