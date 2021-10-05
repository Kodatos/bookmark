package com.kodatos.bookmark.components.image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
            URLImage(url = "#ffd740", modifier = Modifier.size(84.dp, 128.dp).padding(bottom = 8.dp))
            URLImage(url = "#904a50", modifier = Modifier.size(84.dp, 128.dp))
        }
    }
}

