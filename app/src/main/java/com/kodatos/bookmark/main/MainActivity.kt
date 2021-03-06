package com.kodatos.bookmark.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.statusBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kodatos.bookmark.TestViewModel
import com.kodatos.bookmark.surface.PrimaryContainerSurface
import com.kodatos.bookmark.theme.BookmarkTheme
import com.kodatos.bookmark.typography.AppTitle
import com.kodatos.bookmark.typography.HeadingMedium
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val testViewModel: TestViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val systemUiController = rememberSystemUiController()

            BookmarkTheme {
                val useDarkIcons = !isSystemInDarkTheme()

                SideEffect {
                    // Update all of the system bar colors to be transparent, and use
                    // dark icons if we're in light theme
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = useDarkIcons
                    )

                }

                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TestBackdrop(navState: TestViewModel.Nav, setNav: (TestViewModel.Nav) -> Unit) {
    val backdropScaffoldState =
        rememberBackdropScaffoldState(initialValue = BackdropValue.Concealed)
    LaunchedEffect(navState) {
        when (navState) {
            TestViewModel.Nav.FullyConcealed -> backdropScaffoldState.conceal()
            TestViewModel.Nav.PartiallyConcealed -> backdropScaffoldState.conceal()
            TestViewModel.Nav.Revealed -> backdropScaffoldState.reveal()
        }
    }
    val concealedHeight = if (navState is TestViewModel.Nav.PartiallyConcealed) {
        200.dp
    } else 56.dp
    BackdropScaffold(scaffoldState = backdropScaffoldState,
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
                    AppTitle(
                        text = "Bookmark",
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(4.dp)
                    )
                }
            }
        }, backLayerContent = {
            BackLayer()
        }, frontLayerContent = {
            FrontLayer(setNav)
        }, gesturesEnabled = false,
        peekHeight = concealedHeight,
        headerHeight = 0.dp,
        stickyFrontLayer = false
    )
}

@Composable
fun BackLayer() {
    PrimaryContainerSurface(
        modifier = Modifier.fillMaxSize(),
        tonalElevation = 16.dp
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            val ctx = LocalContext.current
            HeadingMedium(text = "Click me", modifier = Modifier
                .clickable {
                    Toast.makeText(ctx, "Clicked", Toast.LENGTH_SHORT).show()
                })
        }
    }
}

@Composable
fun FrontLayer(setNav: (TestViewModel.Nav) -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextButton(onClick = { setNav(TestViewModel.Nav.PartiallyConcealed) }) {
                Text(text = "Partially Concealed")
            }
            TextButton(onClick = { setNav(TestViewModel.Nav.FullyConcealed) }) {
                Text(text = "Fully Concealed")
            }
            TextButton(onClick = { setNav(TestViewModel.Nav.Revealed) }) {
                Text(text = "Revealed")
            }
        }
    }
}
