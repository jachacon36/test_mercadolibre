package com.example.testmercadolibre.presentation.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testmercadolibre.R
import com.example.testmercadolibre.presentation.state.HomeState

@Composable
fun DetailProductScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        TopBar()
        ProductDetails()
        ActionButtons()
    }
}

@Composable
fun TopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF303F9F))
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_menu),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = stringResource(id = R.string.product),
                fontSize = 8.sp,
                modifier = Modifier.weight(1f)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_favorite_border),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_search),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_shopping_cart),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
        Text(
            text = stringResource(id = R.string.direction),
            fontSize = 7.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
fun ProductDetails() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = "Nuevo",
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Moto G6 Dual Sim 32 Gb Índigo Oscuro 3 Gb Ram",
            fontSize = 8.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        // Add more details here
        Text(
            text = "$ 599900",
            fontSize = 14.sp
        )
        Text(
            text = stringResource(id = R.string.free_shipping),
            color = Color.Green,
            fontSize = 7.sp,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = stringResource(id = R.string.stock),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        Text(
            text = "Cantidad: 1/1",
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}

@Composable
fun ActionButtons() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Text(text = stringResource(id = R.string.buy))
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        ) {
            Text(text = stringResource(id = R.string.add_car), color = Color.Blue)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailProductScreenPreview() {
    DetailProductScreen()
}
