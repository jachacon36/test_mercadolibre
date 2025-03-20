package com.example.testmercadolibre.presentation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.testmercadolibre.presentation.viewmodel.HomeViewModel

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    onSearch: (String) -> Unit = {},
) {
    LaunchedEffect(Unit) {
        homeViewModel.getHome()
    }
    val state = homeViewModel.homeState.value
    HomeScreen(state = state, onSearch = { onSearch(it) })
}