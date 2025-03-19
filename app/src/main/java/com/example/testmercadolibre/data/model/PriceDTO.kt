package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class PriceDTO (
    @SerializedName("value")
    val value :String
)