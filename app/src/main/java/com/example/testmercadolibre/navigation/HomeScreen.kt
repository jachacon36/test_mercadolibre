package com.example.testmercadolibre.navigation

import com.example.testmercadolibre.utils.Constant.HOME_SCREEN_ROUTE

sealed class HomeScreen(val route: String) {
    data object Home : HomeScreen(HOME_SCREEN_ROUTE)
}