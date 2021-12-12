package com.kodatos.bookmark.helper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatcherSet {
    val MAIN: CoroutineDispatcher
    val IO: CoroutineDispatcher
    val DEFAULT: CoroutineDispatcher
}
