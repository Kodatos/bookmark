package com.kodatos.shared.domain

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.StateFlow

interface Reducer<State, Event, Action> {

    val state: StateFlow<State>
    val eventChannel: Channel<Event>
    fun dispatch(action: Action)
}