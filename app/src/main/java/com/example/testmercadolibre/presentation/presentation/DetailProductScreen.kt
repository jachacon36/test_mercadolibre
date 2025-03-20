package com.example.testmercadolibre.presentation.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.testmercadolibre.presentation.presentation.composables.ContentSectionDetailProduct
import com.example.testmercadolibre.presentation.presentation.composables.TopBar
import com.example.testmercadolibre.presentation.state.ProductDetailState
import com.example.testmercadolibre.utils.Constant.PRODUCT

@Composable
fun DetailProductScreen(state: ProductDetailState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {

        TopBar(viewType = PRODUCT)
        ContentSectionDetailProduct(state = state)
    }
}

@Preview(showBackground = true)
@Composable
fun DetailProductScreenPreview() {
    DetailProductScreen(ProductDetailState())
}
