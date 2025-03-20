package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.presentation.state.HomeState
import com.example.testmercadolibre.ui.theme.Background
import com.example.testmercadolibre.ui.theme.ColorPrimary

@Composable
fun ContentSectionHome(state: HomeState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column {
                when {
                    state.error -> {
                        ErrorView()
                    }

                    state.data != null -> {
                        ExhibitorRow(state.data.first().elements ?: emptyList())
                        PromotionsColumn(state.data.last().items ?: emptyList())
                    }

                    state.isLoading -> {
                        ProgressBar()
                    }
                }
            }

        }
    }
}