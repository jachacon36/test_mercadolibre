package com.example.testmercadolibre.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.testmercadolibre.presentation.viewmodel.ProductDetailViewModel
import com.example.testmercadolibre.presentation.viewmodel.SearchViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val searchViewModel = hiltViewModel<SearchViewModel>()
    val productDetailViewModel = hiltViewModel<ProductDetailViewModel>()
    NavHost(navController = navController, startDestination = "homeScreen") {
        navigationGraph(
            navGraphController = navController,
            searchViewModel = searchViewModel,
            productDetailViewModel = productDetailViewModel
        )
    }
}