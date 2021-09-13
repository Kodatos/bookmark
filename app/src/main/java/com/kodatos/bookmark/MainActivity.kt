package com.kodatos.bookmark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.kodatos.bookmark.composeutils.collectAsLifecycleAware
import com.kodatos.bookmark.ui.theme.BookmarkTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val testViewModel: TestViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookmarkTheme {
                val navState by testViewModel.navFlow.collectAsLifecycleAware(
                    lifecycleOwner = LocalLifecycleOwner.current,
                    initial = TestViewModel.Nav.PartiallyConcealed
                )
                TestBackdrop(navState) {
                    testViewModel.setNav(it)
                }
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
        100.dp
    } else 56.dp
    BackdropScaffold(scaffoldState = backdropScaffoldState,
        appBar = {
            TopAppBar(title = {
                Text(text = "test")
            })
        }, backLayerContent = {
            BackLayer()
        }, frontLayerContent = {
            FrontLayer(setNav)
        }, gesturesEnabled = false,
        peekHeight = concealedHeight,
        stickyFrontLayer = false
    )
}

@Composable
fun BackLayer() {
    Surface(color = Color.Transparent) {

    }
}

@Composable
fun FrontLayer(setNav: (TestViewModel.Nav) -> Unit) {
    Surface() {
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
