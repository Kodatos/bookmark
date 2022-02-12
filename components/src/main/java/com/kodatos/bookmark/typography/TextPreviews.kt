package com.kodatos.bookmark.typography

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodatos.bookmark.theme.BookmarkTheme

@Preview
@Composable
fun TextPreview() {
    BookmarkTheme(darkTheme = false) {
        Column {
            AppTitle(
                text = "Bookmark",
                modifier = Modifier.padding(4.dp)
            )

            HeadingMedium(
                text = "Heading",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(4.dp)
            )
            BodyMedium(
                text = "Body Large",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(4.dp)
            )
            BodyMediumLowEmphasis(
                text = "Body Large Low Emphasis",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(4.dp)
            )
            BodySmall(
                text = "Body Small",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(4.dp)
            )
            Surface(
                tonalElevation = 4.dp
            ) {
                BodySmall(
                    text = "Body Small Surface Elevated",
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
            BodySmallLowEmphasis(
                text = "Body Small Low Emphasis",
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(4.dp)
            )
            Surface(
                color = MaterialTheme.colorScheme.primary
            ) {
                BodyMediumLowEmphasis(
                    text = "Body Medium Low Emphasis",
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
        }
    }
}
