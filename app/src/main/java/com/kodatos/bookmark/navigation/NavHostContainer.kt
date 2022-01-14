package com.kodatos.bookmark.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kodatos.bookmark.explore.ExploreScreenViewModel
import com.kodatos.shared.domain.destinations.Destination

@Composable
fun NavHostContainer(
    navController: NavHostController,
    screenMetaData: Set<ScreenMetaData>,
    startScreen: Destination,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startScreen.route
    ) {
        screenMetaData.forEach {
            composable(it.path, it.argsList) { backStackEntry ->
                when (it.destination) {
                    Destination.EXPLORE -> {
                    }
                    Destination.BOOKSHELF -> {

                    }
                }
            }
        }
    }
}
