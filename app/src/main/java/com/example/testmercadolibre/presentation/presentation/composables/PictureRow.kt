package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.domain.model.PictureURLDomainModel

@Composable
fun PictureRow(items: List<PictureURLDomainModel>) {
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items.forEach { pictureURLDomainModel ->
            ItemPicture(pictureURLDomainModel = pictureURLDomainModel)
        }
    }
}