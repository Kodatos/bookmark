package com.kodatos.bookmark.typography

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.displayLarge,
        modifier = modifier
    )
}

@Composable
fun HeadingItalic(text: String, modifier: Modifier = Modifier) {

    Text(
        text = text,
        style = MaterialTheme.typography.headlineMedium,
        modifier = modifier
    )

}

@Composable
fun BodyMedium(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}

@Composable
fun BodyMediumLowEmphasis(text: String, modifier: Modifier = Modifier) {

    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier,
        color = LocalContentColor.current.run {
            copy(alpha = 0.75f * this.alpha)
        }
    )

}

@Composable
fun BodySmall(text: String, modifier: Modifier = Modifier) {

    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier
    )

}

@Composable
fun BodySmallLowEmphasis(text: String, modifier: Modifier = Modifier) {

    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier,
        color = LocalContentColor.current.run {
            copy(alpha = 0.75f * this.alpha)
        }
    )

}


