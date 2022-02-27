package com.kodatos.bookmark.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.kodatos.bookmark.bookshelf.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun NavHostContainer(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    DestinationsNavHost(
        navGraph = NavGraphs.root,
        modifier = modifier,
        navController = navController,
    )
}
