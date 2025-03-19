package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class ComponentDTO(
    @SerializedName("type")
    val type: String,
    @SerializedName("elements")
    val elements: List<ElementDTO>,
    @SerializedName("items")
    val items: List<ItemDTO>
)