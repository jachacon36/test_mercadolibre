package com.example.testmercadolibre.presentation.presentation

import androidx.compose.runtime.Composable
import com.example.testmercadolibre.presentation.viewmodel.HomeViewModel

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    onSearch: (String) -> Unit = {}
) {
    val state = homeViewModel.homeState.value
    HomeScreen(state = state, onSearch = {onSearch(it)})
}