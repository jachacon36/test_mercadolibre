package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.testmercadolibre.R
import com.example.testmercadolibre.domain.model.PictureURLDomainModel

@Composable
fun ItemPicture(pictureURLDomainModel: PictureURLDomainModel) {
    val configuration = LocalConfiguration.current
    val screenWidth = (configuration.screenWidthDp.dp - 44.dp)
    Image(
        painter = rememberAsyncImagePainter(
            model = pictureURLDomainModel.url,
            error = painterResource(R.drawable.baseline_broken_image)
        ),
        contentScale = ContentScale.Inside,
        contentDescription = null,
        modifier = Modifier
            .width(screenWidth)
            .height(250.dp)
            .background(Color.White)
    )

}