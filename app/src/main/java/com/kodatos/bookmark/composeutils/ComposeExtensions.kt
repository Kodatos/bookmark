package com.kodatos.bookmark.composeutils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow

@Composable
fun <T> Flow<T>.collectAsLifecycleAware(lifecycleOwner: LifecycleOwner, initial: T) = remember(this, lifecycleOwner) {
    this.flowWithLifecycle(lifecycleOwner.lifecycle)
}.collectAsState(initial = initial)
