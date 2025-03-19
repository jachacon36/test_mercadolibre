package com.example.testmercadolibre.data.model

import com.google.gson.annotations.SerializedName

data class SearchDTO(
    @SerializedName("results")
    val results : List<ResultDTO>
)