package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class ShippingDTO (
    @SerializedName("free_shipping")
    val freeShipping: Boolean
)