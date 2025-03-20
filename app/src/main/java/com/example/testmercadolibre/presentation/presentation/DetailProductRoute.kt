package com.example.testmercadolibre.presentation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.testmercadolibre.presentation.viewmodel.ProductDetailViewModel

@Composable
fun DetailProductRoute(
    productDetailViewModel: ProductDetailViewModel,
    id: String
) {
    LaunchedEffect(Unit) {
        productDetailViewModel.geProductDetail(id = id)
    }
    val state = productDetailViewModel.productDetailState.value
    DetailProductScreen(state = state)
}