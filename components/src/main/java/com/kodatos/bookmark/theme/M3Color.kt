package com.kodatos.bookmark.theme
import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.Dp
import kotlin.math.ln


val md_theme_light_primary = Color(0xFF9c414b)
val md_theme_light_onPrimary = Color(0xFFffffff)
val md_theme_light_primaryContainer = Color(0xFFffdadc)
val md_theme_light_onPrimaryContainer = Color(0xFF40000c)
val md_theme_light_secondary = Color(0xFF775658)
val md_theme_light_onSecondary = Color(0xFFffffff)
val md_theme_light_secondaryContainer = Color(0xFFffdadb)
val md_theme_light_onSecondaryContainer = Color(0xFF2c1517)
val md_theme_light_tertiary = Color(0xFF765930)
val md_theme_light_onTertiary = Color(0xFFffffff)
val md_theme_light_tertiaryContainer = Color(0xFFffddaf)
val md_theme_light_onTertiaryContainer = Color(0xFF2a1800)
val md_theme_light_error = Color(0xFFba1b1b)
val md_theme_light_errorContainer = Color(0xFFffdad4)
val md_theme_light_onError = Color(0xFFffffff)
val md_theme_light_onErrorContainer = Color(0xFF410001)
val md_theme_light_background = Color(0xFFfcfcfc)
val md_theme_light_onBackground = Color(0xFF201a1a)
val md_theme_light_surface = Color(0xFFfcfcfc)
val md_theme_light_onSurface = Color(0xFF201a1a)
val md_theme_light_surfaceVariant = Color(0xFFf4dddd)
val md_theme_light_onSurfaceVariant = Color(0xFF534344)
val md_theme_light_outline = Color(0xFF847373)
val md_theme_light_inverseOnSurface = Color(0xFFfbeded)
val md_theme_light_inverseSurface = Color(0xFF362f2f)

val md_theme_dark_primary = Color(0xFFffb3b9)
val md_theme_dark_onPrimary = Color(0xFF5f121f)
val md_theme_dark_primaryContainer = Color(0xFF7d2934)
val md_theme_dark_onPrimaryContainer = Color(0xFFffdadc)
val md_theme_dark_secondary = Color(0xFFe6bdbe)
val md_theme_dark_onSecondary = Color(0xFF44292b)
val md_theme_dark_secondaryContainer = Color(0xFF5d3f41)
val md_theme_dark_onSecondaryContainer = Color(0xFFffdadb)
val md_theme_dark_tertiary = Color(0xFFe7c08d)
val md_theme_dark_onTertiary = Color(0xFF432c06)
val md_theme_dark_tertiaryContainer = Color(0xFF5c421a)
val md_theme_dark_onTertiaryContainer = Color(0xFFffddaf)
val md_theme_dark_error = Color(0xFFffb4a9)
val md_theme_dark_errorContainer = Color(0xFF930006)
val md_theme_dark_onError = Color(0xFF680003)
val md_theme_dark_onErrorContainer = Color(0xFFffdad4)
val md_theme_dark_background = Color(0xFF201a1a)
val md_theme_dark_onBackground = Color(0xFFecdfdf)
val md_theme_dark_surface = Color(0xFF201a1a)
val md_theme_dark_onSurface = Color(0xFFecdfdf)
val md_theme_dark_surfaceVariant = Color(0xFF534344)
val md_theme_dark_onSurfaceVariant = Color(0xFFd7c2c2)
val md_theme_dark_outline = Color(0xFF9f8c8c)
val md_theme_dark_inverseOnSurface = Color(0xFF201a1a)
val md_theme_dark_inverseSurface = Color(0xFFecdfdf)

val seed = Color(0xFF904a50)
val error = Color(0xFFba1b1b)

fun ColorScheme.elevateByPrimary(color: Color, elevation: Dp): Color {
    val alpha = ((4.5f * ln(elevation.value + 1)) + 2f) / 100f
    return primary.copy(alpha = alpha).compositeOver(color)
}