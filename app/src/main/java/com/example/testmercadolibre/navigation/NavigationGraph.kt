package com.example.testmercadolibre.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.testmercadolibre.presentation.presentation.HomeRoute
import com.example.testmercadolibre.presentation.presentation.SearchRoute
import com.example.testmercadolibre.presentation.viewmodel.HomeViewModel
import com.example.testmercadolibre.presentation.viewmodel.ProductDetailViewModel
import com.example.testmercadolibre.presentation.viewmodel.SearchViewModel

fun NavGraphBuilder.navigationGraph(
    navGraphController: NavHostController,
    searchViewModel: SearchViewModel,
    productDetailViewModel: ProductDetailViewModel,
    homeViewModel: HomeViewModel
) {
    composable("homeScreen") {
        HomeRoute(
            homeViewModel = homeViewModel,
            onSearch = { query ->
                navGraphController.navigate("searchScreen/$query")
            }
        )
    }
    composable("searchScreen/{query}") { backStackEntry ->
        val query = backStackEntry.arguments?.getString("query") ?: ""
        SearchRoute(
            searchViewModel = searchViewModel,
            query = query
        )
    }
}