package com.kodatos.bookmark.components.typography

import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.kodatos.bookmark.components.theme.LocalBookmarkColors

@Composable
fun AppTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = LocalBookmarkColors.current.onPrimarySurface,
        style = MaterialTheme.typography.h1,
        modifier = modifier
    )
}

@Composable
fun HeadingPrimarySurface(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = LocalBookmarkColors.current.onPrimarySurface,
        style = MaterialTheme.typography.h3,
        modifier = modifier
    )
}

@Composable
fun Heading(text: String, modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
        Text(
            text = text,
            style = MaterialTheme.typography.h3,
            modifier = modifier
        )
    }
}

@Composable
fun BodyLarge(text: String, modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            modifier = modifier
        )
    }
}

@Composable
fun BodyLargeLowEmphasis(text: String, modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            modifier = modifier
        )
    }
}

@Composable
fun BodySmall(text: String, modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            modifier = modifier
        )
    }
}

@Composable
fun BodySmallLowEmphasis(text: String, modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            modifier = modifier
        )
    }
}


