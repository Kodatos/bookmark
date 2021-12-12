package com.kodatos.bookmark.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodatos.bookmark.helper.DispatcherSet
import com.kodatos.bookmark.helper.EventConsumer
import com.kodatos.shared.domain.unit.Action
import com.kodatos.shared.domain.unit.DomainUnit
import com.kodatos.shared.domain.unit.State
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseScreenViewModel<S : State, A : Action>(
    protected val domainUnit: DomainUnit<S, A>,
    protected val eventConsumer: EventConsumer,
    protected val dispatchers: DispatcherSet
): ViewModel() {

    val state = domainUnit::state

    init {
        viewModelScope.launch(dispatchers.DEFAULT) {
            domainUnit.sharedEventFlow.collect {
                eventConsumer.triggerEvent(it)
            }
        }
    }

    protected fun dispatchAction(action: A, dispatcher: CoroutineDispatcher = dispatchers.DEFAULT) {
        viewModelScope.launch(dispatcher) {
            domainUnit.dispatch(action)
        }
    }
}