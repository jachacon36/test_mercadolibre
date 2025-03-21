package com.example.testmercadolibre.presentation.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testmercadolibre.R
import com.example.testmercadolibre.presentation.presentation.composables.ContentSectionSearch
import com.example.testmercadolibre.presentation.presentation.composables.TopBar
import com.example.testmercadolibre.presentation.state.SearchState
import com.example.testmercadolibre.utils.Constant.SEARCH

@Composable
fun SearchScreen(
    state: SearchState,
    onSearch: (String) -> Unit = {},
    onItemSelected: (String) -> Unit = {},
    onBackPressed: () -> Unit = {},
    query: String,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
    ) {
        TopBar(query = query, viewType = SEARCH, onSearch = onSearch)
        ContentSectionSearch(state = state, onItemSelected = onItemSelected)
    }
    BackHandler {
        onBackPressed()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(SearchState(), query = "")
}