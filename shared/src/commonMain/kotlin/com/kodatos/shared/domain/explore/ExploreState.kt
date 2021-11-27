package com.kodatos.shared.domain.explore

import com.kodatos.shared.domain.common.Book
import com.kodatos.shared.domain.unit.ProgressBarLoadingState
import com.kodatos.shared.domain.unit.State

sealed interface ExploreState: State {

    object Loading : ProgressBarLoadingState("Exploring..."), ExploreState

    data class ExploreBooksState(
       val books: List<Book>
    ): ExploreState
}
