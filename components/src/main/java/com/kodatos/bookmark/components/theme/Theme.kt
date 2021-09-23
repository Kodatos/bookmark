package com.kodatos.bookmark.components.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val DarkColorPalette = darkColors(
        primary = Crantini500,
        primaryVariant = Crantini700,
        secondary = Daisy300
)

private val LightColorPalette = lightColors(
        primary = Crantini300,
        primaryVariant = Crantini700,
        secondary = Daisy300

        /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

val Colors.systemBar: Color
    @Composable get() = Crantini800

val Colors.appTitle: Color
    @Composable get() = Color.White

@Composable
fun BookmarkTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = BookmarkTypography,
            shapes = Shapes,
            content = content
    )
}
