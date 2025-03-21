package com.example.testmercadolibre.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.testmercadolibre.presentation.viewmodel.HomeViewModel
import com.example.testmercadolibre.presentation.viewmodel.ProductDetailViewModel
import com.example.testmercadolibre.presentation.viewmodel.SearchViewModel
import com.example.testmercadolibre.utils.Constant.HOME_SCREEN_ROUTE

@Composable
fun NavGraph(navController: NavHostController) {
    val searchViewModel = hiltViewModel<SearchViewModel>()
    val productDetailViewModel = hiltViewModel<ProductDetailViewModel>()
    val homeViewModel = hiltViewModel<HomeViewModel>()
    NavHost(navController = navController, startDestination = HOME_SCREEN_ROUTE) {
        navigationGraph(
            navGraphController = navController,
            searchViewModel = searchViewModel,
            productDetailViewModel = productDetailViewModel,
            homeViewModel = homeViewModel
        )
    }
}