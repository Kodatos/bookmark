package com.kodatos.bookmark.helper

import com.kodatos.shared.domain.unit.event.NavEvent
import com.kodatos.shared.domain.unit.event.UIEvent
import kotlinx.coroutines.channels.Channel

interface EventChannelProducer {
    val navigationChannel: Channel<NavEvent>
    val uiEventChannel: Channel<UIEvent>
}