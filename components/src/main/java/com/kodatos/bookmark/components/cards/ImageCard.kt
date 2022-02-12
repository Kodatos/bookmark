package com.kodatos.bookmark.components.cards

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.kodatos.bookmark.image.URLImage

@Composable
fun ImageCard(
    url: String?,
    elevation: Dp,
    cornerSize: Dp,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shadowElevation = elevation,
        shape = RoundedCornerShape(cornerSize)
    ) {
        url?.let {
            URLImage(url = url, modifier = Modifier.fillMaxSize())
        }
    }
}