package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.runtime.Composable
import com.example.testmercadolibre.domain.model.ResultDomainModel

@Composable
fun SearchResultList(items: List<ResultDomainModel>, onItemSelected: (String) -> Unit) {
    items.forEach { item ->
        ItemResult(item = item, onItemSelected = onItemSelected)
    }
}