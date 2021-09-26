package com.kodatos.bookmark.components.typography

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodatos.bookmark.components.theme.BookmarkTheme

@Preview
@Composable
fun TextPreview() {
    BookmarkTheme(darkTheme = false) {
        Column {
            AppTitle(
                text = "Bookmark",
                modifier = Modifier.padding(4.dp)
            )
            HeadingPrimarySurface(
                text = "Heading Primary Surface", modifier = Modifier.padding(4.dp)
            )
            Heading(
                text = "Heading",
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .padding(4.dp)
            )
            BodyLarge(
                text = "Body Large",
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .padding(4.dp)
            )
            BodyLargeLowEmphasis(
                text = "Body Large Low Emphasis",
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .padding(4.dp)
            )
            BodySmall(
                text = "Body Small",
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .padding(4.dp)
            )
            BodySmallLowEmphasis(
                text = "Body Small Low Emphasis",
                modifier = Modifier
                    .background(MaterialTheme.colors.surface)
                    .padding(4.dp)
            )
        }
    }
}
