package com.example.testmercadolibre.domain.model


data class ComponentDomainModel (
    val type :String,
    val elements : List<ElementDomainModel>? = arrayListOf(),
    val items: List<ItemDomainModel> = arrayListOf()
)