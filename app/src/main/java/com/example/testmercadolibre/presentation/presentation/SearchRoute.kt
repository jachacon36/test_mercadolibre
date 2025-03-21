package com.example.testmercadolibre.presentation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.testmercadolibre.presentation.viewmodel.SearchViewModel

@Composable
fun SearchRoute(
    searchViewModel: SearchViewModel,
    query: String,
    onItemSelected: (String) -> Unit = {},
    onBackPressed: () -> Unit = {},
) {
    println("SearchRoute: $query")
    LaunchedEffect(Unit) {
        if (searchViewModel.searchState.value.data == null) {
            searchViewModel.getSearch(query)
        }
    }
    val state = searchViewModel.searchState.value

    SearchScreen(
        state = state,
        query = query,
        onSearch = {
            searchViewModel.getSearch(it)
        },
        onItemSelected = { onItemSelected(it) },
        onBackPressed = {
            searchViewModel.clearSearch()
            onBackPressed()
        }
    )
}