package com.example.testmercadolibre.presentation.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.testmercadolibre.R
import com.example.testmercadolibre.presentation.presentation.composables.ContentSectionHome
import com.example.testmercadolibre.presentation.presentation.composables.TopBar
import com.example.testmercadolibre.presentation.state.HomeState
import com.example.testmercadolibre.utils.Constant.SEARCH

@Composable
fun HomeScreen(state: HomeState, onSearch: (String) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(colorResource(id = R.color.background))
    ) {
        TopBar(viewType = SEARCH, onSearch = { onSearch(it) })
        ContentSectionHome(state = state)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(HomeState(), onSearch = {})
}