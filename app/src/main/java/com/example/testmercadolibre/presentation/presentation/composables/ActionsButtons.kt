package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.R
import com.example.testmercadolibre.ui.theme.Blue
import com.example.testmercadolibre.ui.theme.BuyButton
import com.example.testmercadolibre.ui.theme.FavoriteButton

@Composable
fun ActionButtons() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(BuyButton),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(text = stringResource(id = R.string.buy))
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(FavoriteButton),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(text = stringResource(id = R.string.add_car), color = Blue)
        }
    }
}

@Preview
@Composable
fun ActionButtonsPreview() {
    ActionButtons()
}