package com.example.testmercadolibre.presentation.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testmercadolibre.R
import com.example.testmercadolibre.presentation.presentation.composables.ContentSectionHome
import com.example.testmercadolibre.presentation.presentation.composables.TopSection
import com.example.testmercadolibre.presentation.state.HomeState
import com.example.testmercadolibre.presentation.state.SearchState

@Composable
fun HomeScreen(state: HomeState, onSearch: (String) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    ) {
        TopSection(query = "", onSearch = { onSearch(it) })
        ContentSectionHome(state = state)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(HomeState(), onSearch = {})
}