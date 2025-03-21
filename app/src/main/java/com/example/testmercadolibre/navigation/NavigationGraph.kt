package com.example.testmercadolibre.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.testmercadolibre.presentation.presentation.DetailProductRoute
import com.example.testmercadolibre.presentation.presentation.HomeRoute
import com.example.testmercadolibre.presentation.presentation.SearchRoute
import com.example.testmercadolibre.presentation.viewmodel.HomeViewModel
import com.example.testmercadolibre.presentation.viewmodel.ProductDetailViewModel
import com.example.testmercadolibre.presentation.viewmodel.SearchViewModel

fun NavGraphBuilder.navigationGraph(
    navGraphController: NavHostController,
    searchViewModel: SearchViewModel,
    productDetailViewModel: ProductDetailViewModel,
    homeViewModel: HomeViewModel,
) {
    composable("homeScreen") {
        HomeRoute(
            homeViewModel = homeViewModel,
            onSearch = { query ->
                navGraphController.navigate("searchScreen/$query")
                println("homeScreen: $query")
            }
        )
    }
    composable("searchScreen/{query}") { backStackEntry ->
        val query = backStackEntry.arguments?.getString("query") ?: ""
        println("homeScreen: $query")
        SearchRoute(
            searchViewModel = searchViewModel,
            query = query,
            onItemSelected = { id ->
                navGraphController.navigate("detailProduct/$id")
            },
            onBackPressed = {
                navGraphController.navigateUp()
            }
        )
    }
    composable("detailProduct/{id}") { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id") ?: ""
        DetailProductRoute(
            productDetailViewModel = productDetailViewModel,
            id = id,
            onBackPressed = {
                navGraphController.navigateUp()
            }
        )
    }
}