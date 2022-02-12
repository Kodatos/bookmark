package com.kodatos.bookmark.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodatos.bookmark.helper.DispatcherProvider
import com.kodatos.bookmark.helper.EventChannelProducer
import com.kodatos.bookmark.navigation.getRouteForNavigation
import com.kodatos.shared.domain.destinations.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val eventChannelProducer: EventChannelProducer,
    private val dispatcherProvider: DispatcherProvider
): ViewModel() {

    val uiEventFlow = eventChannelProducer.uiEventChannel.receiveAsFlow()
    val navigationChannel = Channel<String>(Channel.BUFFERED)
    val backDropState = MutableStateFlow(BackdropState.FULLY_REVEALED)

    init {
        initNavigationFlow()
    }

    private fun initNavigationFlow() {
        viewModelScope.launch(dispatcherProvider.MAIN) {
            eventChannelProducer.navigationEventFlow.collect {
                handleBackdropState(it.destination)
                if(it.destination != Destination.EXPLORE){
                    navigationChannel.send(getRouteForNavigation(it))
                }
            }
        }
    }

    fun handleBackdropState(destination: Destination) {
        backDropState.value = when (destination) {
            Destination.EXPLORE -> {
                BackdropState.FULLY_REVEALED
            }
            Destination.BOOKSHELF -> {
                BackdropState.PARTIALLY_REVEALED
            }
            else -> {
                BackdropState.CONCEALED
            }
        }
    }
}