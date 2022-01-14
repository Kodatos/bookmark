package com.kodatos.shared.platform

import com.kodatos.shared.domain.explore.ExploreAction
import com.kodatos.shared.domain.explore.ExploreState
import com.kodatos.shared.domain.unit.DomainUnit

interface DomainUnitsProvider {
    val exploreDomainUnit: DomainUnit<ExploreState, ExploreAction>
}