package com.example.testmercadolibre.domain.model


data class ComponentModel (
    val type :String,
    val elements : List<ElementModel>,
    val items: List<ItemModel>
)