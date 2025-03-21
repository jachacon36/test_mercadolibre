package com.example.testmercadolibre.repository

import com.example.testmercadolibre.common.toDomainModel
import com.example.testmercadolibre.data.model.*
import com.example.testmercadolibre.data.network.ApiService
import com.example.testmercadolibre.data.network.LocalService
import com.example.testmercadolibre.data.repository.RepositoryImpl
import com.example.testmercadolibre.utils.Constant.ERROR_LOADING_HOME_DATA
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class RepositoryImplTest {

    @Mock
    private lateinit var apiService: ApiService

    @Mock
    private lateinit var localService: LocalService

    private lateinit var repository: RepositoryImpl

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = RepositoryImpl(apiService, localService)
    }

    @Test
    fun `getSearch returns SearchDomainModel`() = runTest {
        val query = "query"
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
        val expected = searchDTO.toDomainModel()

        `when`(apiService.getSearch(query)).thenReturn(searchDTO)

        val result = repository.getSearch(query)
        assertEquals(expected, result)
    }

    @Test
    fun `getItem returns DetailProductDomainModel`() = runTest {
        val id = "id"
        val detailProductDTO = DetailProductDTO(
            title = "title",
            price = 100,
            initialQuantity = 10,
            availableQuantity = 5,
            condition = "new",
            pictures = listOf(PictureURLDTO(url = "url")),
            shipping = ShippingDTO(freeShipping = true)
        )
        val expected = detailProductDTO.toDomainModel()

        `when`(apiService.getItem(id)).thenReturn(detailProductDTO)

        val result = repository.getItem(id)
        assertEquals(expected, result)
    }

    @Test
    fun `refreshToken returns TokenResponseDomainModel`() = runTest {
        val grantType = "grantType"
        val clientId = "clientId"
        val clientSecret = "clientSecret"
        val refreshToken = "refreshToken"
        val tokenResponseDTO = TokenResponseDTO(
            accessToken = "accessToken",
            expiresIn = 3600,
            tokenType = "Bearer",
            refreshToken = "refreshToken"
        )
        val expected = tokenResponseDTO.toDomainModel()

        `when`(apiService.refreshToken(grantType, clientId, clientSecret, refreshToken)).thenReturn(
            tokenResponseDTO
        )

        val result = repository.refreshToken(grantType, clientId, clientSecret, refreshToken)
        assertEquals(expected, result)
    }

    @Test
    fun `getHome returns ComponetsJSONDomainModel when localService returns data`() = runTest {
        val componetsJSONDTO = ComponetsJSONDTO(
            components = listOf(
                ComponentDTO(
                    type = "type",
                    elements = null,
                    items = null
                )
            )
        )
        val expected = componetsJSONDTO.toDomainModel()

        `when`(localService.getHome()).thenReturn(componetsJSONDTO)

        val result = repository.getHome()
        assertEquals(expected, result)
    }

    @Test
    fun `getHome throws Exception when localService returns null`() = runTest {
        `when`(localService.getHome()).thenReturn(null)

        try {
            repository.getHome()
        } catch (e: Exception) {
            assertEquals(ERROR_LOADING_HOME_DATA, e.message)
        }
    }
}