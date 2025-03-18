package com.example.testmercadolibre.domain.model


data class ComponentDomainModel (
    val type :String,
    val elements : List<ElementDomianModel>,
    val items: List<ItemDomainModel>
)