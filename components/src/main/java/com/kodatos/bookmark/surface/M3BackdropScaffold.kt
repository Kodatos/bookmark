package com.kodatos.bookmark.surface

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropScaffoldDefaults
import androidx.compose.material.BackdropScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsHeight

@ExperimentalMaterialApi
@Composable
fun M3BackdropScaffold(
    scaffoldState: BackdropScaffoldState,
    appBarContent: @Composable (modifier: Modifier) -> Unit,
    backLayerContent: @Composable () -> Unit,
    frontLayerContent: @Composable () -> Unit,
    concealedHeight: Dp,
    modifier: Modifier = Modifier,
    backLayerTonalElevation: Dp = 16.dp,
    gesturesEnabled: Boolean = true,
    headerHeight: Dp = BackdropScaffoldDefaults.HeaderHeight,
) {
    BackdropScaffold(
        appBar = {
            PrimaryContainerSurface(
                tonalElevation = 16.dp,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Spacer(
                        modifier = Modifier
                            .statusBarsHeight(8.dp)
                            .fillMaxWidth()
                    )
                    appBarContent(
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(4.dp)
                    )
                }
            }
        },
        backLayerContent = {
            PrimaryContainerSurface(
                modifier = Modifier.fillMaxSize(),
                tonalElevation = backLayerTonalElevation
            ) {
                backLayerContent()
            }
        },
        frontLayerContent = {
            frontLayerContent()
        },
        scaffoldState = scaffoldState,
        peekHeight = concealedHeight,
        gesturesEnabled = gesturesEnabled,
        modifier = modifier,
        stickyFrontLayer = false,
        backLayerBackgroundColor = MaterialTheme.colorScheme.surface,
        frontLayerBackgroundColor = Color.Transparent,
        frontLayerScrimColor = Color.Unspecified,
        headerHeight = headerHeight,
        frontLayerShape = RoundedCornerShape(0.dp)
    )
}