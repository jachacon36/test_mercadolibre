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
    composable(HomeScreen.Home.route) {
        HomeRoute(
            homeViewModel = homeViewModel,
            onSearch = { query ->
                searchViewModel.query = query
                navGraphController.navigate(SearchScreen.Search.route)
            }
        )
    }
    composable(SearchScreen.Search.route) {
        SearchRoute(
            searchViewModel = searchViewModel,
            query = searchViewModel.query,
            onItemSelected = { id ->
                productDetailViewModel.id = id
                navGraphController.navigate(
                    DetailScreen.Detail.route
                )
            },
            onBackPressed = {
                navGraphController.navigateUp()
            }
        )
    }
    composable(DetailScreen.Detail.route) {
        DetailProductRoute(
            productDetailViewModel = productDetailViewModel,
            id = productDetailViewModel.id,
            onBackPressed = {
                navGraphController.navigateUp()
            }
        )
    }
}