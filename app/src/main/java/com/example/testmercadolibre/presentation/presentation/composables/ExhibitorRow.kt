package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.domain.model.ElementDomainModel
import com.example.testmercadolibre.domain.model.PictureDomainModel
import com.example.testmercadolibre.domain.model.UrlDomainModel
import com.example.testmercadolibre.ui.theme.Background
import com.example.testmercadolibre.ui.theme.ColorPrimary

@Composable
fun ExhibitorRow(items: List<ElementDomainModel>) {
    Box(
        modifier = Modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        ColorPrimary,
                        Background
                    )
                )
            )
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items.forEach { elementDomainModel ->
                ItemExhibitor(elementDomainModel = elementDomainModel)
            }
        }
    }
}

@Preview
@Composable
fun ExhibitorRowPreview() {
    ExhibitorRow(
        items = listOf(
            ElementDomainModel(
                picture = PictureDomainModel(
                    url = UrlDomainModel(
                        src = "",
                    )
                )
            )
        )
    )
}