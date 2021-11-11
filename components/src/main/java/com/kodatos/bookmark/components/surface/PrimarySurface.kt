package com.kodatos.bookmark.components.surface

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kodatos.bookmark.components.theme.elevateByPrimary

@Composable
fun PrimaryContainerSurface(
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.elevateByPrimary(
            MaterialTheme.colorScheme.primaryContainer,
            tonalElevation
        ),
        shadowElevation = shadowElevation,
        tonalElevation = tonalElevation,    //Pass on tonal elevation to wrapped surface
        content = content
    )
}