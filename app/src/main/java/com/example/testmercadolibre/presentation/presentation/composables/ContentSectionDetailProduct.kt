package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.presentation.state.ProductDetailState

@Composable
fun ContentSectionDetailProduct(state: ProductDetailState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Column {
                when {
                    state.error -> {
                        ErrorView()
                    }

                    state.data != null -> {
                        ProductDetails(state.data)
                        ActionButtons()
                    }

                    state.isLoading -> {
                        ProgressBar()
                    }
                }
            }
        }
    }
}