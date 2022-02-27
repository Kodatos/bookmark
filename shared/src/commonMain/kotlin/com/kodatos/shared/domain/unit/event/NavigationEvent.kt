package com.kodatos.shared.domain.unit.event

import com.kodatos.shared.domain.destinations.NavigationArgument
import com.kodatos.shared.domain.destinations.NavigationDestination

class NavigationEvent(val destination: NavigationDestination, val argument: NavigationArgument) :
    Event {
    override fun toString() = "Navigating to ${destination.route}"
}