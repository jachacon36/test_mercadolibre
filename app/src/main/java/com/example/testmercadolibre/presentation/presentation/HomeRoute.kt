package com.example.testmercadolibre.presentation.presentation

import androidx.compose.runtime.Composable
import com.example.testmercadolibre.presentation.viewmodel.SearchViewModel

@Composable
fun HomeRoute(
    searchViewModel: SearchViewModel,
) {
    val state = searchViewModel.searchState.value
    HomeScreen(state = state, onSearch = searchViewModel::getSearch)
}