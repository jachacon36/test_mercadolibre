package com.example.testmercadolibre.viewmodel

import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.domain.model.DetailProductDomainModel
import com.example.testmercadolibre.domain.model.ShippingDomainModel
import com.example.testmercadolibre.domain.usecase.GetProductDetailsUseCase
import com.example.testmercadolibre.presentation.state.ProductDetailState
import com.example.testmercadolibre.presentation.viewmodel.ProductDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
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
class ProductDetailViewModelTest {

    @Mock
    private lateinit var getProductDetailsUseCase: GetProductDetailsUseCase

    private lateinit var productDetailViewModel: ProductDetailViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        MockitoAnnotations.openMocks(this)
        productDetailViewModel = ProductDetailViewModel(getProductDetailsUseCase)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    @DisplayName("Given a product ID, when getProductDetail is called, then productDetailState is updated to loading and then success with data")
    fun `getProductDetail updates productDetailState to loading and then success with data`() =
        runTest {
            val productId = "123"
            val detailProductDomainModel = DetailProductDomainModel(
                title = "Test",
                price = 1000,
                initialQuantity = 10,
                availableQuantity = 10,
                condition = "new",
                pictures = emptyList(),
                shipping = ShippingDomainModel(freeShipping = true)
            )

            `when`(getProductDetailsUseCase.invoke(productId)).thenReturn(flow {
                emit(ViewState.Loading(data = null))
                emit(ViewState.Success(data = detailProductDomainModel))
            })

            productDetailViewModel.getProductDetail(productId)

            advanceUntilIdle()
            assertEquals(false, productDetailViewModel.productDetailState.value.isLoading)
            assertEquals(
                detailProductDomainModel,
                productDetailViewModel.productDetailState.value.data
            )
            assertEquals(false, productDetailViewModel.productDetailState.value.error)
        }

    @Test
    @DisplayName("Given a product ID, when getProductDetail is called, then productDetailState is updated to loading and then error with message")
    fun `getProductDetail updates productDetailState to loading and then error with message`() =
        runTest {
            val productId = "123"
            val errorMessage = "Error"

            `when`(getProductDetailsUseCase.invoke(productId)).thenReturn(flow {
                emit(ViewState.Loading(data = null))
                emit(ViewState.Error(data = null, message = errorMessage))
            })

            productDetailViewModel.getProductDetail(productId)

            advanceUntilIdle()
            assertEquals(false, productDetailViewModel.productDetailState.value.isLoading)
            assertEquals(null, productDetailViewModel.productDetailState.value.data)
            assertEquals(true, productDetailViewModel.productDetailState.value.error)
        }

    @Test
    @DisplayName("When clearProductDetail is called, then productDetailState is reset")
    fun `clearProductDetail resets productDetailState`() = runTest {
        productDetailViewModel.clearProductDedail()
        assertEquals(ProductDetailState(), productDetailViewModel.productDetailState.value)
    }
}