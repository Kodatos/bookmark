package com.kodatos.bookmark.image

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import timber.log.Timber

/**
 * All composables in this file assume an [ImageProvider] is available through a [LocalImageProvider]
 */

@OptIn(ExperimentalCoilApi::class)
@Composable
fun URLImage(url: String, modifier: Modifier = Modifier) {
    val imageLoader = LocalImageProvider.current
    Timber.d("Loading image: $url")
    Image(painter = imageLoader.getPainter(url), contentDescription = null, modifier = modifier)
}

