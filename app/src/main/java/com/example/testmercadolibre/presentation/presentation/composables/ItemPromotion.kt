package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.testmercadolibre.R
import com.example.testmercadolibre.domain.model.DiscountDomainModel
import com.example.testmercadolibre.domain.model.ItemDomainModel
import com.example.testmercadolibre.domain.model.PictureURLDomainModel
import com.example.testmercadolibre.domain.model.PriceDomainModel
import com.example.testmercadolibre.ui.theme.Green

@Composable
fun ItemPromotion(itemDomainModel: ItemDomainModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = itemDomainModel.picture.url,
                error = painterResource(R.drawable.baseline_broken_image)
            ),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 10.dp, top = 15.dp, end = 10.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.price, itemDomainModel.price.value),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .weight(2f)
                )
                Text(
                    text = itemDomainModel.discount.text,
                    style = MaterialTheme.typography.labelSmall,
                    color = Green,
                    modifier = Modifier
                        .weight(1f)
                )
            }

            Text(
                text = itemDomainModel.title,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PromotionItemPreview() {
    ItemPromotion(
        ItemDomainModel(
            title = "Title",
            price = PriceDomainModel(
                value = "2000"
            ),
            discount = DiscountDomainModel(
                text = "10%"
            ),
            picture = PictureURLDomainModel(
                url = "https://http2.mlstatic.com/D_NQ_NP_2X_905235-MLA45628231037_042021-F.png"
            )
        )
    )
}