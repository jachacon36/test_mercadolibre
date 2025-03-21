package com.example.testmercadolibre.presentation.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.testmercadolibre.presentation.viewmodel.HomeViewModel

@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    onSearch: (String) -> Unit = {}
) {
    val state = homeViewModel.homeState.value
    LaunchedEffect(Unit) {
        if (state.data == null){
            homeViewModel.getHome()
        }
    }
    HomeScreen(state = state,onSearch = { onSearch(it) })
}