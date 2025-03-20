package com.example.testmercadolibre.presentation.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testmercadolibre.R
import com.example.testmercadolibre.presentation.presentation.composables.ContentSectionSearch
import com.example.testmercadolibre.presentation.presentation.composables.TopSection
import com.example.testmercadolibre.presentation.state.SearchState

@Composable
fun SearchScreen(state: SearchState, onSearch: (String) -> Unit = {}, query: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    ) {
        TopSection(query = query,onSearch = { onSearch(it) })
        ContentSectionSearch(state = state)
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(SearchState(), query = "")
}