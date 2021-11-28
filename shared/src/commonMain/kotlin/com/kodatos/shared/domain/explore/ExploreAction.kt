package com.kodatos.shared.domain.explore

import com.kodatos.shared.domain.BestsellerList

sealed interface ExploreAction {
    class Load(val categories: List<BestsellerList>): ExploreAction
    object Click: ExploreAction
}