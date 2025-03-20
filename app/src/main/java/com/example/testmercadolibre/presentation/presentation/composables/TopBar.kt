package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.R
import com.example.testmercadolibre.ui.theme.ColorAccent
import com.example.testmercadolibre.utils.Constant.PRODUCT
import com.example.testmercadolibre.utils.Constant.SEARCH

@Composable
fun TopBar(query: String = "", viewType: String, onSearch: (String) -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.colorPrimaryDark))
            .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (viewType) {
                PRODUCT -> {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_menu),
                        contentDescription = null,
                        tint = colorResource(id = R.color.colorAccent),
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = stringResource(id = R.string.product),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_favorite_border),
                        contentDescription = null,
                        tint = ColorAccent,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search),
                        contentDescription = null,
                        tint = ColorAccent,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_shopping_cart),
                        contentDescription = null,
                        tint = ColorAccent,
                        modifier = Modifier.size(30.dp)
                    )
                }

                SEARCH -> {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_menu),
                        contentDescription = null,
                        tint = ColorAccent,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    SearchView(
                        modifier = Modifier.weight(1f),
                        query = query,
                        onSearch = { onSearch(it) })
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_shopping_cart),
                        contentDescription = null,
                        tint = ColorAccent,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_place),
                contentDescription = null,
                tint = colorResource(id = R.color.colorAccent),
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = stringResource(id = R.string.direction),
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right),
                contentDescription = null,
                tint = colorResource(id = R.color.colorAccent),
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreviewProduct() {
    TopBar(viewType = PRODUCT, onSearch = {})
}

@Preview(showBackground = true)
@Composable
fun TopBarPreviewSearch() {
    TopBar(viewType = SEARCH, onSearch = {})
}