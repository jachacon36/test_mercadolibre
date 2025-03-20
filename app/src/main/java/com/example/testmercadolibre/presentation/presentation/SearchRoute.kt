package com.example.testmercadolibre.presentation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.testmercadolibre.presentation.viewmodel.SearchViewModel

@Composable
fun SearchRoute(
    searchViewModel: SearchViewModel,
    query: String,
) {
    val state = searchViewModel.searchState.value

    LaunchedEffect(Unit) {
        searchViewModel.getSearch(query)
    }

    SearchScreen(state = state, query = query,onSearch = searchViewModel::getSearch)
}