package com.kodatos.bookmark.helper

import com.kodatos.shared.domain.unit.event.Event
import com.kodatos.shared.domain.unit.event.NavigationEvent
import com.kodatos.shared.domain.unit.event.UIEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventManager @Inject constructor() : EventConsumer, EventChannelProducer {

    private val _navigationFlow = MutableSharedFlow<NavigationEvent>()
    override val navigationEventFlow
        get() = _navigationFlow
    override val uiEventChannel = Channel<UIEvent>(Channel.BUFFERED)

    override suspend fun triggerEvent(event: Event) {
        Timber.d(event.toString())
        if (event is NavigationEvent) {
            navigationEventFlow.emit(event)
        } else if (event is UIEvent)
            uiEventChannel.send(event)
        else {
            Timber.d("Unhandled event: ${event.javaClass.simpleName} - $event")
        }
    }
}