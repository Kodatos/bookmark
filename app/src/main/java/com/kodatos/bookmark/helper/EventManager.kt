package com.kodatos.bookmark.helper

import com.kodatos.shared.domain.unit.event.Event
import com.kodatos.shared.domain.unit.event.NavEvent
import com.kodatos.shared.domain.unit.event.UIEvent
import kotlinx.coroutines.channels.Channel
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventManager @Inject constructor() : EventConsumer, EventChannelProducer {

    override val navigationChannel = Channel<NavEvent>(Channel.BUFFERED)
    override val uiEventChannel = Channel<UIEvent>(Channel.BUFFERED)

    override suspend fun triggerEvent(event: Event) {
        Timber.d(event.toString())
        if(event is NavEvent)
            navigationChannel.send(event)
        else if (event is UIEvent)
            uiEventChannel.send(event)
        else {
            Timber.d("Unhandled event: ${event.javaClass.simpleName}")
        }
    }
}