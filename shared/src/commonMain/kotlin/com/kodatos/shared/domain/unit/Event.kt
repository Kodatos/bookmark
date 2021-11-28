package com.kodatos.shared.domain.unit

import com.kodatos.shared.domain.destinations.Destination
import com.kodatos.shared.domain.destinations.DestinationArg

sealed interface Event

class NavEvent<T: DestinationArg>(destination: Destination<T>): Event
class ToastEvent(text: String, duration: Duration): Event {
    companion object {
        enum class Duration { SHORT, LONG}
    }
}