package com.kodatos.shared.domain.unit.event

sealed interface UIEvent: Event

class ToastEvent(text: String, duration: Duration): UIEvent {
    companion object {
        enum class Duration { SHORT, LONG}
    }
}