package com.kodatos.bookmark.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodatos.bookmark.helper.DispatcherProvider
import com.kodatos.bookmark.helper.EventChannelProducer
import com.kodatos.shared.domain.destinations.NavigationDestination
import com.kodatos.shared.domain.unit.event.NavigationEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val eventChannelProducer: EventChannelProducer,
    private val dispatcherProvider: DispatcherProvider
): ViewModel() {

    val uiEventFlow = eventChannelProducer.uiEventChannel.receiveAsFlow()
    val navigationChannel = Channel<NavigationEvent>(Channel.BUFFERED)
    val backDropState = MutableStateFlow(BackdropState.PARTIALLY_REVEALED)

    init {
        initNavigationFlow()
    }

    private fun initNavigationFlow() {
        viewModelScope.launch(dispatcherProvider.MAIN) {
            eventChannelProducer.navigationEventFlow.collect {
                handleBackdropState(it.destination)
                if (it.destination != NavigationDestination.EXPLORE) {
                    navigationChannel.send(it)
                }
            }
        }
    }

    fun handleBackdropState(destination: NavigationDestination) {
        backDropState.value = when (destination) {
            NavigationDestination.EXPLORE -> {
                BackdropState.FULLY_REVEALED
            }
            NavigationDestination.BOOKSHELF -> {
                BackdropState.PARTIALLY_REVEALED
            }
            else -> {
                BackdropState.CONCEALED
            }
        }
    }
}