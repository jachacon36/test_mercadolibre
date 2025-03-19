package com.example.testmercadolibre.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val colorScheme = lightColorScheme(
    primary = ColorPrimary,
    secondary = ColorPrimaryDark,
    tertiary = ColorAccent,
)

@Composable
fun TestMercadolibreTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}