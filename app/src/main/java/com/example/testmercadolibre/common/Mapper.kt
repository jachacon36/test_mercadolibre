package com.example.testmercadolibre.common

import com.example.testmercadolibre.data.model.*
import com.example.testmercadolibre.domain.model.*

fun ComponentDTO.toDomainModel(): ComponentDomainModel {
    return ComponentDomainModel(
        type = this.type,
        elements = this.elements?.map { it.toDomainModel() } ?: emptyList(),
        items = this.items?.map { it.toDomainModel() } ?: emptyList()
    )
}

fun ElementDTO.toDomainModel(): ElementDomainModel {
    return ElementDomainModel(
        picture = this.picture.toDomainModel()
    )
}

fun PictureDTO.toDomainModel(): PictureDomainModel {
    return PictureDomainModel(
        url = this.url.toDomainModel()
    )
}

fun UrlDTO.toDomainModel(): UrlDomainModel {
    return UrlDomainModel(
        src = this.src
    )
}

fun DetailProductDTO.toDomainModel(): DetailProductDomainModel {
    return DetailProductDomainModel(
        title = this.title,
        price = this.price,
        initialQuantity = this.initialQuantity,
        availableQuantity = this.initialQuantity,
        condition = this.condition,
        pictures = this.pictures.map { it.toDomainModel() },
        shipping = this.shipping.toDomainModel()
    )
}

fun PictureURLDTO.toDomainModel(): PictureURLDomainModel {
    return PictureURLDomainModel(
        url = this.url
    )
}

fun ShippingDTO.toDomainModel(): ShippingDomainModel {
    return ShippingDomainModel(
        freeShipping = this.freeShipping
    )
}

fun DiscountDTO.toDomainModel(): DiscountDomainModel {
    return DiscountDomainModel(
        text = this.text
    )
}

fun ItemDTO.toDomainModel(): ItemDomainModel {
    return ItemDomainModel(
        title = this.title,
        price = this.price.toDomainModel(),
        discount = this.discount.toDomainModel(),
        picture = this.picture.toDomainModel()
    )
}

fun PriceDTO.toDomainModel(): PriceDomainModel {
    return PriceDomainModel(
        value = this.value
    )
}

fun ComponetsJSONDTO.toDomainModel(): ComponetsJSONDomainModel {
    return ComponetsJSONDomainModel(
        components = this.components.map { it.toDomainModel() }
    )
}

fun SearchDTO.toDomainModel(): SearchDomainModel {
    return SearchDomainModel(
        results = this.results.map { it.toDomainModel() }
    )
}

fun ResultDTO.toDomainModel(): ResultDomainModel {
    return ResultDomainModel(
        id = this.id,
        title = this.title,
        price = this.price,
        thumbnail = this.thumbnail,
        installments = this.installments?.toDomainModel(),
        shipping = this.shipping.toDomainModel()
    )
}

fun InstallmentsDTO.toDomainModel(): InstallmentsDomainModel {
    return InstallmentsDomainModel(
        quantity = this.quantity,
        amount = this.amount
    )
}

fun TokenResponseDTO.toDomainModel(): TokenResponseDomainModel {
    return TokenResponseDomainModel(
        accessToken = this.accessToken,
        expiresIn = this.expiresIn,
        tokenType = this.tokenType,
        refreshToken = this.refreshToken
    )
}