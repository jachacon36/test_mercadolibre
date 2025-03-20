package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.testmercadolibre.R
import com.example.testmercadolibre.domain.model.ElementDomainModel

@Composable
fun ItemExhibitor(elementDomainModel: ElementDomainModel) {
    val configuration = LocalConfiguration.current
    val screenWidth = (configuration.screenWidthDp.dp-44.dp)

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(screenWidth)
            .height(150.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = elementDomainModel.picture.url.src,
                placeholder = painterResource(R.drawable.thumbnail),
                error = painterResource(R.drawable.baseline_broken_image)
            ),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .width(screenWidth)
                .height(150.dp)
                .background(Color.White)
        )
    }
}