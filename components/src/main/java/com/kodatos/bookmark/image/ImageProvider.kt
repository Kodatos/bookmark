package com.kodatos.bookmark.image

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.painter.Painter
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter

/**
 * Interface which abstracts providing images to composables.
 */
interface ImageProvider {
    /**
     * Returns a [Painter] for a given url
     */
    @Composable
    fun getPainter(url: String): Painter
}

/**
 * Implementation of [ImageProvider] using Coil as a image loader.
 */
object CoilImageProvider : ImageProvider {
    @OptIn(ExperimentalCoilApi::class)
    @Composable
    override fun getPainter(url: String): ImagePainter {
        return rememberImagePainter(url, builder = {
            crossfade(true)
        })
    }
}

val LocalImageProvider =
    staticCompositionLocalOf<ImageProvider> { throw IllegalStateException("Should be set at top level") }


