package com.kodatos.bookmark.helper

import com.kodatos.shared.domain.unit.event.Event

interface EventConsumer {
    suspend fun triggerEvent(event: Event)
}