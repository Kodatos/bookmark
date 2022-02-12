package com.kodatos.bookmark.explore

import androidx.lifecycle.viewModelScope
import com.kodatos.bookmark.base.BaseScreenViewModel
import com.kodatos.bookmark.helper.DispatcherProvider
import com.kodatos.bookmark.helper.EventConsumer
import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.domain.explore.ExploreAction
import com.kodatos.shared.domain.explore.ExploreDomainUnit
import com.kodatos.shared.domain.explore.ExploreState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ExploreScreenViewModel @Inject constructor(
    domainUnit: ExploreDomainUnit,
    eventConsumer: EventConsumer,
    dispatchers: DispatcherProvider
) : BaseScreenViewModel<ExploreState, ExploreAction>(
    domainUnit, eventConsumer, dispatchers,
) {

    init {
        dispatchAction(ExploreAction.Load(enumValues<BestsellerList>().toList()))
        viewModelScope.launch {
            state.collect() {
                Timber.d("Viewmodel State: ${state.value::class.java}")
            }
        }
    }
}