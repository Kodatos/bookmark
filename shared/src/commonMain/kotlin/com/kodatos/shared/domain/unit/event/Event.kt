package com.kodatos.shared.domain.unit.event

import com.kodatos.shared.domain.destinations.Destination

sealed interface Event

class NavEvent(destination: Destination<*>): Event
