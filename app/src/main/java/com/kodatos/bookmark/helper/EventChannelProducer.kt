package com.kodatos.bookmark.helper

import com.kodatos.shared.domain.unit.event.NavigationEvent
import com.kodatos.shared.domain.unit.event.UIEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.SharedFlow

interface EventChannelProducer {
    val navigationEventFlow: SharedFlow<NavigationEvent>
    val uiEventChannel: Channel<UIEvent>
}