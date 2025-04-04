package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testmercadolibre.presentation.state.SearchState

@Composable
fun ContentSectionSearch(state: SearchState, onItemSelected: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
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
                        SearchResultList(items = state.data.results, onItemSelected = onItemSelected)
                    }

                    state.isLoading -> {
                        ProgressBar()
                    }
                }
            }
        }
    }
}