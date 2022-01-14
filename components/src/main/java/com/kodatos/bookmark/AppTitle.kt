package com.kodatos.bookmark

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodatos.bookmark.components.R
import com.kodatos.bookmark.theme.BookmarkTheme
import com.kodatos.bookmark.typography.AppTitle

@Composable
fun BookmarkTitle(modifier: Modifier = Modifier) {
    Box(modifier.then(Modifier.fillMaxWidth())) {
        Row(Modifier.align(Alignment.Center)) {
            Image(
                painter = painterResource(id = R.drawable.ic_app_title),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp, 42.dp)
                    .padding(top = 4.dp, bottom = 2.dp)
            )
            AppTitle(
                text = "Bookmark",
                modifier = Modifier.padding(start = 6.dp, top = 2.dp, bottom = 4.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF72363d,
)
@Composable
private fun Preview() {
    BookmarkTheme {
        Box {
            BookmarkTitle(Modifier.align(Alignment.TopCenter))
        }
    }
}
