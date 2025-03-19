package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class PictureDTO(
    @SerializedName("url")
    val url: UrlDTO
)