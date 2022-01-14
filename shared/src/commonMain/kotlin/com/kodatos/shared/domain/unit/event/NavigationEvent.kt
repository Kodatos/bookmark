package com.kodatos.shared.domain.unit.event

import com.kodatos.shared.domain.destinations.NavigationArgument
import com.kodatos.shared.domain.destinations.Destination

class NavigationEvent(val destination: Destination, val argument: NavigationArgument): Event {
    override fun toString() = "Navigating to ${destination.route}"
}