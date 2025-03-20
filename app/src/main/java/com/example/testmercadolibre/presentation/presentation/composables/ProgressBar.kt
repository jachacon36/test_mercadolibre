package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testmercadolibre.ui.theme.Blue

@Composable
fun ProgressBar() {
    CircularProgressIndicator(
        color = Blue,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Preview
@Composable
fun ProgressBarPreview() {
    ProgressBar()
}