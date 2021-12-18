package com.kodatos.bookmark.explore

import com.kodatos.bookmark.helper.DispatcherProvider
import com.kodatos.bookmark.helper.EventConsumer
import com.kodatos.bookmark.viewmodels.BaseScreenViewModel
import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.domain.explore.ExploreAction
import com.kodatos.shared.domain.explore.ExploreState
import com.kodatos.shared.domain.unit.DomainUnit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExploreScreenViewModel @Inject constructor(
    domainUnit: DomainUnit<ExploreState, ExploreAction>,
    eventConsumer: EventConsumer,
    dispatchers: DispatcherProvider
) : BaseScreenViewModel<ExploreState, ExploreAction>(
    domainUnit, eventConsumer, dispatchers,
) {

    init {
        dispatchAction(ExploreAction.Load(enumValues<BestsellerList>().toList()))
    }
}