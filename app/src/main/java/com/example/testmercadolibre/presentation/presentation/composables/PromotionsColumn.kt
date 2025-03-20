package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.domain.model.ItemDomainModel
import com.example.testmercadolibre.ui.theme.White

@Composable
fun PromotionsColumn(items: List<ItemDomainModel>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .padding(16.dp)
            .background(color = White, shape = RoundedCornerShape(8.dp))
    ) {
        items(items) { item ->
            PromotionItem(itemDomainModel = item)
        }
    }
}