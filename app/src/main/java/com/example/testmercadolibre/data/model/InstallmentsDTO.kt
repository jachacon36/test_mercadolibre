package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class InstallmentsDTO(
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("amount")
    val amount: Double
)