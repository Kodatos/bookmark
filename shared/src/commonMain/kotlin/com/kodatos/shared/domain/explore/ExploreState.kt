package com.kodatos.shared.domain.explore

import com.kodatos.shared.domain.unit.ProgressBarLoadingState
import com.kodatos.shared.domain.unit.State

sealed interface ExploreState: State {

    object Init : ProgressBarLoadingState("Exploring..."), ExploreState
    object Error: ExploreState

    data class ExploreBooksState(
        val books: List<ExploreBook>
    ): ExploreState

}
