package com.kodatos.bookmark.navigation

import com.kodatos.shared.domain.destinations.EmptyArgs
import com.kodatos.shared.domain.destinations.ExploreDestination

class ExploreScreen(override val destination: ExploreDestination) : Screen<ExploreDestination> {
    override fun getStringArgs(): String {
        return ""
    }
}