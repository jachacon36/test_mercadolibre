package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.R

@Composable
fun SearchView(
    modifier: Modifier = Modifier,
) {
    TextField(
        value = "Samsung",
        shape = RoundedCornerShape(30.dp),
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search),
                contentDescription = null,
                tint = colorResource(id = R.color.colorAccent),
                modifier = Modifier.size(30.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            disabledTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,

            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    SearchView()
}