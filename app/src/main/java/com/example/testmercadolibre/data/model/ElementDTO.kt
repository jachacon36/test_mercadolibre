package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class ElementDTO(
    @SerializedName("picture")
    val picture: PictureDTO
)