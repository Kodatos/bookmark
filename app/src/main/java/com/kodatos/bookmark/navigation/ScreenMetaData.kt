package com.kodatos.bookmark.navigation

import androidx.navigation.NamedNavArgument
import com.kodatos.shared.domain.destinations.Destination

data class ScreenMetaData(
    val destination: Destination,
    val path: String,
    val argsList: List<NamedNavArgument>,
)