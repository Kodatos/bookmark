package com.kodatos.bookmark.components.theme

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

/**
 * Class with colors that augment [androidx.compose.material.Colors], while still using
 * [androidx.compose.material.MaterialTheme] as the base theming system
 */
@Stable
class BookmarkColors(systemBar: Color, onPrimarySurface: Color) {
    var systemBar by mutableStateOf(systemBar)
        internal set
    var onPrimarySurface by mutableStateOf(onPrimarySurface)
        internal set
}

val LocalBookmarkColors =
    compositionLocalOf<BookmarkColors> { throw IllegalStateException("Should be set in theme") }
