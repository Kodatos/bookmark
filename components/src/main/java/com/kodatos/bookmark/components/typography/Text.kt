package com.kodatos.bookmark.components.typography

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kodatos.bookmark.components.theme.appTitle

@Composable
fun AppTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = MaterialTheme.colors.appTitle,
        style = MaterialTheme.typography.h3,
        modifier = modifier
    )
}
