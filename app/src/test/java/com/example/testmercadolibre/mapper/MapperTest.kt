package com.example.testmercadolibre.mapper

import com.example.testmercadolibre.common.*
import com.example.testmercadolibre.data.model.*
import com.example.testmercadolibre.domain.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MapperTest {

    @Test
    fun `ComponentDTO toDomainModel maps correctly`() {
        val componentDTO = ComponentDTO(
            type = "type",
            elements = listOf(ElementDTO(picture = PictureDTO(url = UrlDTO(src = "src")))),
            items = listOf(
                ItemDTO(
                    title = "title",
                    price = PriceDTO(value = "100"),
                    discount = DiscountDTO(text = "discount"),
                    picture = PictureURLDTO(url = "url")
                )
            )
        )
        val expected = ComponentDomainModel(
            type = "type",
            elements = listOf(
                ElementDomainModel(
                    picture = PictureDomainModel(
                        url = UrlDomainModel(
                            src = "src"
                        )
                    )
                )
            ),
            items = listOf(
                ItemDomainModel(
                    title = "title",
                    price = PriceDomainModel(value = "100"),
                    discount = DiscountDomainModel(text = "discount"),
                    picture = PictureURLDomainModel(url = "url")
                )
            )
        )
        assertEquals(expected, componentDTO.toDomainModel())
    }

    @Test
    fun `DetailProductDTO toDomainModel maps correctly`() {
        val detailProductDTO = DetailProductDTO(
            title = "title",
            price = 100,
            initialQuantity = 10,
            availableQuantity = 5,
            condition = "new",
            pictures = listOf(PictureURLDTO(url = "url")),
            shipping = ShippingDTO(freeShipping = true)
        )
        val expected = DetailProductDomainModel(
            title = "title",
            price = 100,
            initialQuantity = 10,
            availableQuantity = 10,
            condition = "new",
            pictures = listOf(PictureURLDomainModel(url = "url")),
            shipping = ShippingDomainModel(freeShipping = true)
        )
        assertEquals(expected, detailProductDTO.toDomainModel())
    }

    @Test
    fun `ComponetsJSONDTO toDomainModel maps correctly`() {
        val componetsJSONDTO = ComponetsJSONDTO(
            components = listOf(ComponentDTO(type = "type", elements = null, items = null))
        )
        val expected = ComponetsJSONDomainModel(
            components = listOf(
                ComponentDomainModel(
                    type = "type",
                    elements = emptyList(),
                    items = emptyList()
                )
            )
        )
        assertEquals(expected, componetsJSONDTO.toDomainModel())
    }

    @Test
    fun `SearchDTO toDomainModel maps correctly`() {
        val searchDTO = SearchDTO(
            results = listOf(
                ResultDTO(
                    id = "id",
                    title = "title",
                    price = "100",
                    thumbnail = "thumbnail",
                    installments = InstallmentsDTO(quantity = 10, amount = 10.0),
                    shipping = ShippingDTO(freeShipping = true)
                )
            )
        )
        val expected = SearchDomainModel(
            results = listOf(
                ResultDomainModel(
                    id = "id",
                    title = "title",
                    price = "100",
                    thumbnail = "thumbnail",
                    installments = InstallmentsDomainModel(quantity = 10, amount = 10.0),
                    shipping = ShippingDomainModel(freeShipping = true)
                )
            )
        )
        assertEquals(expected, searchDTO.toDomainModel())
    }

    @Test
    fun `TokenResponseDTO toDomainModel maps correctly`() {
        val tokenResponseDTO = TokenResponseDTO(
            accessToken = "accessToken",
            expiresIn = 3600,
            tokenType = "Bearer",
            refreshToken = "refreshToken"
        )
        val expected = TokenResponseDomainModel(
            accessToken = "accessToken",
            expiresIn = 3600,
            tokenType = "Bearer",
            refreshToken = "refreshToken"
        )
        assertEquals(expected, tokenResponseDTO.toDomainModel())
    }
}