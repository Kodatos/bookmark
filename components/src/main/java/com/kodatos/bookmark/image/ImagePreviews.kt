package com.kodatos.bookmark.image

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodatos.bookmark.components.cards.ImageCard

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
internal fun ImagePreviews() {
    val hexColorImageProvider = object : ImageProvider {
        // Returns a ColorPainter assuming url is a hex code. Use only in previews
        @Composable
        override fun getPainter(url: String): Painter {
            return ColorPainter(Color(android.graphics.Color.parseColor(url)))
        }
    }
    CompositionLocalProvider(LocalImageProvider provides hexColorImageProvider) {
        Column() {
            URLImage(
                url = "#ffd740", modifier = Modifier
                    .size(64.dp, 128.dp)
                    .padding(bottom = 8.dp)
            )
            URLImage(url = "#904a50", modifier = Modifier.size(84.dp, 128.dp))
            LazyVerticalGrid(
                cells = GridCells.Fixed(3),
                contentPadding = PaddingValues(horizontal = 8.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                items(
                    listOf(
                        "#904a50",
                        "#904050",
                        "#904150",
                        "#904a50",
                        "#904050",
                        "#904150"
                    )
                ) { book ->
                    ImageCard(
                        url = book,
                        modifier = Modifier
                            .height(128.dp)
                            .padding(8.dp),
                        elevation = 4.dp,
                        cornerSize = 4.dp,
                    )
                }
            }
        }
    }
}

