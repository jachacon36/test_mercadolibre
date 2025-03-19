package com.example.testmercadolibre.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmercadolibre.common.ViewState
import com.example.testmercadolibre.domain.usecase.GetProductDetailsUseCase
import com.example.testmercadolibre.presentation.state.ProductDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val getProductDetailsUseCase: GetProductDetailsUseCase) :
    ViewModel() {

    private val _productDetailState = mutableStateOf(ProductDetailState())
    val productDetailState: State<ProductDetailState> get() = _productDetailState

    fun geProductDetail(id: String) {
        getProductDetailsUseCase.invoke(id = id).onEach {
            when (it) {
                is ViewState.Loading -> {
                    _productDetailState.value = ProductDetailState(isLoading = true)
                }

                is ViewState.Success -> {
                    _productDetailState.value = ProductDetailState(data = it.data)
                }

                is ViewState.Error -> {
                    _productDetailState.value = ProductDetailState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}