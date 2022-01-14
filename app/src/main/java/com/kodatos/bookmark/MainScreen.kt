package com.kodatos.bookmark

import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.kodatos.bookmark.viewmodels.MainViewModel

@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val mainviewModel: MainViewModel = hiltViewModel()
    val backdropState = rememberBackdropScaffoldState(initialValue = BackdropValue.Revealed)
}

object MainScreenConstants {
    const val BACKDROP = "backdrop"
    const val BACKDROP_CONCEALED = "concealed"
    const val BACKDROP_PARTIALLY_REVEALED = "partially_revealed"
    const val BACKDROP_FULLY_REVEALED = "fully_revealed"
}