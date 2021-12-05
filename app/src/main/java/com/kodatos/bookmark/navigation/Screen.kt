package com.kodatos.bookmark.navigation

import com.kodatos.shared.domain.destinations.Destination
import com.kodatos.shared.domain.destinations.DestinationArg
import com.kodatos.shared.domain.destinations.EmptyArgs

sealed interface Screen<T: Destination<*>>{
    abstract val destination: T
    abstract fun getStringArgs(): String

}