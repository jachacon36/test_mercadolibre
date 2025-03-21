package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.R
import com.example.testmercadolibre.domain.model.DetailProductDomainModel
import com.example.testmercadolibre.domain.model.ShippingDomainModel
import com.example.testmercadolibre.ui.theme.Green

@Composable
fun ProductDetails(detailProductDomainModel: DetailProductDomainModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = detailProductDomainModel.condition,
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = detailProductDomainModel.title,
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        PictureRow(items = detailProductDomainModel.pictures)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(
                id = R.string.price,
                detailProductDomainModel.price
            ),
            style = MaterialTheme.typography.displayMedium,
        )
        Spacer(modifier = Modifier.height(10.dp))
        if (detailProductDomainModel.shipping.freeShipping) {
            Text(
                text = stringResource(id = R.string.free_shipping),
                color = Green,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
        Text(
            text = stringResource(id = R.string.stock),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = stringResource(
                id = R.string.quantity,
                detailProductDomainModel.availableQuantity,
                detailProductDomainModel.initialQuantity
            ),
            style = MaterialTheme.typography.displaySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    ProductDetails(
        DetailProductDomainModel(
            title = "Samsung galaxy",
            price = 1000,
            initialQuantity = 1,
            availableQuantity = 1,
            condition = "new",
            pictures = arrayListOf(),
            shipping = ShippingDomainModel(true)
        )
    )
}