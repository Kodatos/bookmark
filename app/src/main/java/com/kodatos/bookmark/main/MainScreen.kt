package com.kodatos.bookmark.main

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kodatos.bookmark.R
import com.kodatos.bookmark.composeutils.collectStateLifecycleAware
import com.kodatos.bookmark.explore.ExploreScreen
import com.kodatos.bookmark.surface.M3BackdropScaffold
import com.kodatos.bookmark.typography.AppTitle

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen() {
    val mainviewModel: MainViewModel = hiltViewModel()
    val lifecycleOwner = LocalLifecycleOwner.current
    val backdropScaffoldState =
        rememberBackdropScaffoldState(initialValue = BackdropValue.Concealed)
    val backdropState by mainviewModel.backDropState.collectStateLifecycleAware(
        lifecycleOwner = lifecycleOwner
    )
    LaunchedEffect(backdropState) {
        if (backdropState == BackdropState.FULLY_REVEALED)
            backdropScaffoldState.reveal()
        else backdropScaffoldState.conceal()
    }
    val concealedHeight: Dp by animateDpAsState(
        targetValue = if (backdropState == BackdropState.PARTIALLY_REVEALED)
            ConcealedHeight.PARTIAL.height
        else ConcealedHeight.FULL.height
    )

    M3BackdropScaffold(
        scaffoldState = backdropScaffoldState,
        appBarContent = { appBarModifier ->
            AppTitle(
                text = stringResource(id = R.string.app_name),
                Modifier then appBarModifier
            )
        },
        backLayerContent = { ExploreScreen(hiltViewModel()) },
        frontLayerContent = { },
        concealedHeight = concealedHeight,
        gesturesEnabled = false
    )
}

enum class ConcealedHeight(val height: Dp) {
    PARTIAL(256.dp),
    FULL(56.dp)
}