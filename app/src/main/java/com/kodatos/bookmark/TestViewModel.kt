package com.kodatos.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor() : ViewModel() {

    private val navChannel = Channel<Nav>(Channel.BUFFERED)
    val navFlow = navChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            navChannel.send(Nav.PartiallyConcealed)
        }
    }

    sealed class Nav {
        object PartiallyConcealed : Nav()
        object FullyConcealed : Nav()
        object Revealed : Nav()
    }

    fun setNav(nav: Nav){
        viewModelScope.launch {
            navChannel.send(nav)
        }
    }
}