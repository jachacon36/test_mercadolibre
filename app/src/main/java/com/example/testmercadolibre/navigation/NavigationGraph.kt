package com.example.testmercadolibre.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.testmercadolibre.presentation.presentation.HomeRoute
import com.example.testmercadolibre.presentation.viewmodel.ProductDetailViewModel
import com.example.testmercadolibre.presentation.viewmodel.SearchViewModel

fun NavGraphBuilder.navigationGraph(
    navGraphController: NavHostController,
    searchViewModel: SearchViewModel,
    productDetailViewModel: ProductDetailViewModel,
) {
    composable("homeScreen") {
        HomeRoute(
            searchViewModel = searchViewModel
        )
    }
}