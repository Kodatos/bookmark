package com.kodatos.bookmark.components.cards

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.kodatos.bookmark.image.URLImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageCard(
    url: String?,
    cornerSize: Dp,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier,
        shape = RoundedCornerShape(cornerSize),
    ) {
        url?.let {
            URLImage(url = url, modifier = Modifier.fillMaxSize())
        }
    }
}