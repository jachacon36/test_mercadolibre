package com.example.testmercadolibre.data.model


data class ComponentDTO (
    val type :String,
    val elements : List<ElementDTO>,
    val items: List<ItemDTO>
)