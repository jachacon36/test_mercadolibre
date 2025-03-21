package com.example.testmercadolibre.presentation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.testmercadolibre.presentation.viewmodel.ProductDetailViewModel

@Composable
fun DetailProductRoute(
    productDetailViewModel: ProductDetailViewModel,
    id: String,
    onBackPressed: () -> Unit = {},
) {
    val state = productDetailViewModel.productDetailState.value
    LaunchedEffect(Unit) {
        if (state.data == null) {
            productDetailViewModel.getProductDetail(id = id)
        }
    }
    DetailProductScreen(state = state, onBackPressed = {
        productDetailViewModel.clearProductDedail()
        onBackPressed()
    })
}