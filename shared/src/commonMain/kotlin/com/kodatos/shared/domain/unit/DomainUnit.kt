package com.kodatos.shared.domain.unit

import com.kodatos.shared.domain.unit.event.Event
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * A DomainUnit represents an abstraction over all business logic pertaining to a particular screen
 * or an independent portion for it. It can consume [Action]s specified by [A], which should either
 * result in a change of [State] specified by [S], or an emission of an [Event].
 *
 * 1. Expected consumers of a domain unit are Android's ViewModel, iOS's Presenter or any other equivalent
 * logic mediators. They should interact with it only through [dispatch], and can expect results
 * through [state] and [sharedEventFlow]
 * 2. A [State] represents data pertaining, and limited to, the screen for which the corresponding
 * mediator is acting on behalf of. It is monolithic, and separating the state into discrete
 * components is a responsibility of the mediator or the view controller
 * 3. An [Event] however pertains to the entire application lifecycle, examples include showing
 * ephemeral UIs like snackbars and static modal dialogs, navigating to other screens and other
 * variants of one-off events which are common for the app. As such, the consuming mediators should
 * ideally forward these events to a common event controller.
 */
abstract class DomainUnit<S : State, A : Action>(private val initialState: S) {

    /**
     * Holds the state for the screen. Subclasses should back this up with a mutable state flow,
     * taking care of initial states.
     */
    private val _state = MutableStateFlow<S>(initialState)
    val state: StateFlow<S>
        get() = _state

    private val events = MutableSharedFlow<Event>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    /**
     * A [SharedFlow] which emits [Event]s. It only buffers the last event and will start dropping
     * events if the collector is suspended. Hence it is recommended that consumer(mediator)
     * lifecycle doesn't suspend and that the mediator instead handles consistency with the
     * view lifecycle
     */
    val sharedEventFlow: SharedFlow<Event>
        get() = events

    protected fun sendEvent(event: Event) {
        events.tryEmit(event)
    }

    protected fun setState(newState: S) {
        _state.value = newState
    }

    abstract suspend fun dispatch(action: A)
}

