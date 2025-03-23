package com.example.testmercadolibre.navigation

import com.example.testmercadolibre.utils.Constant.DETAIL_PRODUCT_ROUTE

sealed class DetailScreen(val route: String) {
    data object Detail : DetailScreen(DETAIL_PRODUCT_ROUTE)
}