package com.example.testmercadolibre.presentation.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testmercadolibre.R
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import com.example.testmercadolibre.ui.theme.ColorAccent

@Composable
fun SearchView(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {},
    query: String,
) {
    var searchText by remember { mutableStateOf(query) }
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = searchText,
        shape = RoundedCornerShape(30.dp),
        onValueChange = {
            searchText = it
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_search),
                contentDescription = null,
                tint = ColorAccent,
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
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                val trimmedText = searchText.trim().replace(Regex("\\s+"), " ")
                if (trimmedText.isNotEmpty()) {
                    onSearch(trimmedText)
                    keyboardController?.hide()
                }
            }
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    SearchView(query = "", onSearch = {})
}