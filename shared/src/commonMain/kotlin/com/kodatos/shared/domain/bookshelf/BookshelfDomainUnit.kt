package com.kodatos.shared.domain.bookshelf

import com.kodatos.shared.di.SharedSingleton
import com.kodatos.shared.domain.destinations.NavigationDestination
import com.kodatos.shared.domain.unit.DomainUnit
import com.kodatos.shared.domain.unit.event.NavigationEvent
import me.tatarka.inject.annotations.Inject

@SharedSingleton
@Inject
class BookshelfDomainUnit : DomainUnit<BookshelfState, BookshelfAction>(BookshelfState(false)) {
    override suspend fun dispatch(action: BookshelfAction) {
        when (action) {
            BookshelfAction.ExpandClick -> {
                val isCollapsed = currentState.collapsed
                sendEvent(
                    NavigationEvent(
                        if (isCollapsed)
                            NavigationDestination.Bookshelf()
                        else NavigationDestination.Explore()
                    )
                )
                setState(BookshelfState(!isCollapsed))
            }
        }
    }
}