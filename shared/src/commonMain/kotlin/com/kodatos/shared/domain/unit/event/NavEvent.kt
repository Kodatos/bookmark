package com.kodatos.shared.domain.unit.event

import com.kodatos.shared.domain.destinations.Destination

class NavEvent(val destination: Destination<*>): Event {
    override fun asString() = "Navigating to ${destination.route}"
}