package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testmercadolibre.presentation.state.HomeState

@Composable
fun ContentSectionHome(state: HomeState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        when {
            state.error -> {
                ErrorView()
            }

            state.data != null -> {
                ExhibitorRow(state.data.first().elements ?: emptyList())
                PromotionsGrid(state.data.last().items ?: emptyList())
            }

            state.isLoading -> {
                ProgressBar()
            }
        }
    }
}