package com.example.testmercadolibre.usecase

import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.data.repository.RepositoryImpl
import com.example.testmercadolibre.domain.model.DetailProductDomainModel
import com.example.testmercadolibre.domain.model.ShippingDomainModel
import com.example.testmercadolibre.domain.usecase.GetProductDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExperimentalCoroutinesApi
@ExtendWith(MockitoExtension::class)
class GetProductDetailsUseCaseTest {

    @Mock
    private lateinit var repositoryImpl: RepositoryImpl

    private lateinit var getProductDetailsUseCase: GetProductDetailsUseCase

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockitoAnnotations.openMocks(this)
        getProductDetailsUseCase = GetProductDetailsUseCase(repositoryImpl)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    @DisplayName("Given a valid product ID, when invoke is called, then emits loading and success with data")
    fun `invoke emits loading and success with data`() = runTest {
        val productId = "123"
        val productDetail = DetailProductDomainModel(
            title = "Test",
            price = 1000,
            initialQuantity = 10,
            availableQuantity = 10,
            condition = "new",
            pictures = emptyList(),
            shipping = ShippingDomainModel(freeShipping = true)
        )

        `when`(repositoryImpl.getItem(productId)).thenReturn(productDetail)

        val flow = getProductDetailsUseCase.invoke(productId)

        val emissions = flow.toList()

        assertEquals(ViewState.Loading::class, emissions[0]::class)
        assertEquals(ViewState.Success::class, emissions[1]::class)
        assertEquals(productDetail, (emissions[1] as ViewState.Success).data)
    }

    @Test
    @DisplayName("Given a valid product ID, when invoke is called, then emits loading and error with message")
    fun `invoke emits loading and error with message`() = runTest {
        val productId = "123"
        val errorMessage = "Error"

        `when`(repositoryImpl.getItem(productId)).thenThrow(RuntimeException(errorMessage))

        val flow = getProductDetailsUseCase.invoke(productId)

        val emissions = flow.toList()
        Assertions.assertTrue(emissions[0] is ViewState.Loading<*>)
        Assertions.assertTrue(emissions[1] is ViewState.Error<*> && (emissions[1] as ViewState.Error).message == errorMessage)
    }
}