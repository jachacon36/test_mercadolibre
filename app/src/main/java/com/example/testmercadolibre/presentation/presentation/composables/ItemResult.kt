package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.R
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.example.testmercadolibre.domain.model.InstallmentsDomainModel
import com.example.testmercadolibre.domain.model.ResultDomainModel
import com.example.testmercadolibre.domain.model.ShippingDomainModel

@Composable
fun ItemResult(item: ResultDomainModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.white))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.thumbnail),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .width(150.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 15.dp)
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "$ ${item.price}",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                item.installments?.let { installments ->
                    Text(
                        text = "en ${installments.quantity}x ${installments.amount}",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                when {
                    item.shipping.freeShipping -> {
                        Text(
                            text = stringResource(id = R.string.free_shipping),
                            style = MaterialTheme.typography.labelSmall,
                            color = colorResource(id = R.color.green),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Column {
                Spacer(modifier = Modifier.height(15.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_favorite_border),
                    contentDescription = null,
                    tint = colorResource(id = R.color.blue),
                    modifier = Modifier
                        .height(20.dp)
                )
            }

        }
        Divider(color = colorResource(id = R.color.background), thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun ItemResultPreview() {
    ItemResult(
        ResultDomainModel(
            "1",
            "title",
            "100.0",
            "https://http2.mlstatic.com/D_682268-MLA45719482741_042021-O.jpg",
            shipping = ShippingDomainModel(true),
            installments = InstallmentsDomainModel(12, 10.0)
        )
    )
}