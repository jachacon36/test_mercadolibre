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
import com.example.testmercadolibre.utils.Constant.DETAIL_PRODUCT_ROUTE
import com.example.testmercadolibre.utils.Constant.DETAIL_PRODUCT_ROUTE_WITH_ID
import com.example.testmercadolibre.utils.Constant.HOME_SCREEN_ROUTE
import com.example.testmercadolibre.utils.Constant.ID_ARGUMENT
import com.example.testmercadolibre.utils.Constant.QUERY_ARGUMENT
import com.example.testmercadolibre.utils.Constant.SEARCH_SCREEN_ROUTE
import com.example.testmercadolibre.utils.Constant.SEARCH_SCREEN_ROUTE_WITH_QUERY
import com.example.testmercadolibre.utils.toStringOrEmpty

fun NavGraphBuilder.navigationGraph(
    navGraphController: NavHostController,
    searchViewModel: SearchViewModel,
    productDetailViewModel: ProductDetailViewModel,
    homeViewModel: HomeViewModel,
) {
    composable(HOME_SCREEN_ROUTE) {
        HomeRoute(
            homeViewModel = homeViewModel,
            onSearch = { query ->
                navGraphController.navigate(String.format(SEARCH_SCREEN_ROUTE_WITH_QUERY, query))
                println("homeScreen: $query")
            }
        )
    }
    composable(SEARCH_SCREEN_ROUTE) { backStackEntry ->
        val query = backStackEntry.arguments?.getString(QUERY_ARGUMENT) ?: String().toStringOrEmpty()
        println("homeScreen: $query")
        SearchRoute(
            searchViewModel = searchViewModel,
            query = query,
            onItemSelected = { id ->
                navGraphController.navigate(String.format(DETAIL_PRODUCT_ROUTE_WITH_ID, id))
            },
            onBackPressed = {
                navGraphController.navigateUp()
            }
        )
    }
    composable(DETAIL_PRODUCT_ROUTE) { backStackEntry ->
        val id = backStackEntry.arguments?.getString(ID_ARGUMENT) ?: String().toStringOrEmpty()
        DetailProductRoute(
            productDetailViewModel = productDetailViewModel,
            id = id,
            onBackPressed = {
                navGraphController.navigateUp()
            }
        )
    }
}