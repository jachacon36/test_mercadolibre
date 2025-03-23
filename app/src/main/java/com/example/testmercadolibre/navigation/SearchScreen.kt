package com.example.testmercadolibre.navigation

import com.example.testmercadolibre.utils.Constant.SEARCH_SCREEN_ROUTE

sealed class SearchScreen(val route: String) {
    data object Search : SearchScreen(SEARCH_SCREEN_ROUTE)
}