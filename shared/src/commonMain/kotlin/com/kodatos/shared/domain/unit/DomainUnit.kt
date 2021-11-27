package com.kodatos.shared.domain.unit

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow

interface DomainUnit<S: State, E: Event, Action> {

    val state: StateFlow<S>
    val eventChannel: Channel<E>
    fun dispatch(action: Action)
}

interface Event