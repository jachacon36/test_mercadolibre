package com.example.testmercadolibre.domain.model

data class TokenResponseDomainModel(
    val accessToken: String,
    val tokenType: String,
    val expiresIn: Int,
    val refreshToken: String
)