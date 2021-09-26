package com.kodatos.bookmark.components.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color


private val DarkColorPalette = darkColors(
    primary = Crantini500,
    primaryVariant = Crantini700,
    secondary = Daisy300
)

private val LightColorPalette = lightColors(
    primary = Crantini300,
    primaryVariant = Crantini700,
    secondary = Daisy300,
    onSurface = ContentBlack

    /* Other default colors to override
background = Color.White,
surface = Color.White,
onPrimary = Color.White,
onSecondary = Color.Black,
onBackground = Color.Black,
onSurface = Color.Black,
*/
)


@Composable
fun BookmarkTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val bookmarkColors: BookmarkColors = remember {
        BookmarkColors(systemBar = Crantini800, onPrimarySurface = Color.White)
    }
    CompositionLocalProvider(LocalBookmarkColors provides bookmarkColors) {
        MaterialTheme(
            colors = colors,
            typography = BookmarkTypography,
            shapes = Shapes,
            content = content
        )
    }

}
