package com.kodatos.bookmark.components.typography

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodatos.bookmark.components.theme.BookmarkTheme

@Preview
@Composable
fun TextPreview() {
    BookmarkTheme(darkTheme = false) {
        Column() {
            AppTitle(
                text = "Bookmark",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
