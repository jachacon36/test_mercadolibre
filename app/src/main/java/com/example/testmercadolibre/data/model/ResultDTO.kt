package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class ResultDTO (
    @SerializedName("id")
    val id : String,
    @SerializedName("title")
    val title : String,
    @SerializedName("price")
    val price: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("installments")
    val installments : InstallmentsDTO?,
    @SerializedName("shipping")
    val shipping: ShippingDTO
)