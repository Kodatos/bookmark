package com.kodatos.shared.domain.unit

import com.kodatos.shared.domain.unit.event.Event
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow

interface DomainUnit<S: State, Action> {

    val state: StateFlow<S>
    val eventChannel: Channel<Event>
    suspend fun dispatch(action: Action)
}
