package com.example.testmercadolibre.common

import com.example.testmercadolibre.data.model.*
import com.example.testmercadolibre.domain.model.*

fun ComponentDTO.toDomainModel(): ComponentDomainModel {
    return ComponentDomainModel(
        type = this.type,
        elements = this.elements.map { it.toDomainModel() },
        items = this.items.map { it.toDomainModel() }
    )
}

fun ElementDTO.toDomainModel(): ElementDomianModel {
    return ElementDomianModel(
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
        initial_quantity = this.initial_quantity,
        available_quantity = this.available_quantity,
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
        free_shipping = this.free_shipping
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

