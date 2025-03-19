package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProgressBar(visible: Boolean) {
    if (visible) {
        CircularProgressIndicator(
            modifier = Modifier
        )
    }
}