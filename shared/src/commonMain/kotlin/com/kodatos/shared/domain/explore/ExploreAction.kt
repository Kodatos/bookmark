package com.kodatos.shared.domain.explore

import com.kodatos.shared.domain.BestsellerList
import com.kodatos.shared.domain.common.Book
import com.kodatos.shared.domain.unit.Action

sealed interface ExploreAction: Action {
    class Load(val categories: List<BestsellerList>): ExploreAction
    class BookClick(val book: Book): ExploreAction
}