package com.kodatos.shared.domain.unit.event

/**
 * A sealed interface for one-off, consumable events including, but not limited to,
 * common UI events, navigation events, etc. This is sealed so that platform application code
 * can expect a finite set of events that it is expected to handle.
 */
sealed interface Event {
    /**
     * Returns a representative string for logging purposes
     */
    fun asString(): String
}

