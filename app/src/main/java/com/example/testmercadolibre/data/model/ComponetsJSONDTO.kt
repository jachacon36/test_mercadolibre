package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class ComponetsJSONDTO(
    @SerializedName("components")
    val components: List<ComponentDTO>
)