package com.kodatos.shared.domain.unit.event

sealed interface UIEvent: Event

class ToastEvent(val text: String, val duration: Duration): UIEvent {
    override fun toString() = "Showing toast with text $text and for a $duration time"
    enum class Duration { SHORT, LONG }

}