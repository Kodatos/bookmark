package com.kodatos.bookmark.explore

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kodatos.bookmark.R
import com.kodatos.bookmark.components.cards.ImageCard
import com.kodatos.bookmark.composeutils.collectStateLifecycleAware
import com.kodatos.bookmark.typography.HeadingMedium
import com.kodatos.shared.domain.explore.ExploreState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExploreScreen(viewModel: ExploreScreenViewModel) {
    val state by viewModel.state.collectStateLifecycleAware(
        lifecycleOwner = LocalLifecycleOwner.current
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        HeadingMedium(
            text = stringResource(id = R.string.bestseller_headline),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        state.let { state ->
            if (state is ExploreState.ExploreBooksState) {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(3),
                    contentPadding = PaddingValues(all = 8.dp),
                    modifier = Modifier.fillMaxHeight()
                ) {
                    items(state.books) { book ->
                        ImageCard(
                            url = book.imageUrl,
                            elevation = 4.dp,
                            cornerSize = 4.dp,
                            modifier = Modifier
                                .height(196.dp)
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}