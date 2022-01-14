package com.kodatos.bookmark.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * All composables in this file assume an [ImageProvider] is available through a [LocalImageProvider]
 */

@Composable
fun URLImage(url: String, modifier: Modifier = Modifier) {
    val imageLoader = LocalImageProvider.current
    Image(painter = imageLoader.getPainter(url), contentDescription = null, modifier = modifier)
}

