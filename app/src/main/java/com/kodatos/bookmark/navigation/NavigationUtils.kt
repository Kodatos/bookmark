package com.kodatos.bookmark.navigation

import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.kodatos.shared.domain.destinations.*
import com.kodatos.shared.domain.unit.event.NavigationEvent

private fun getArgsList(destination: Destination): List<NamedNavArgument> {
    return when (destination.expectedArgument) {
        ExpectedArgument.NO_ARGS -> {
            emptyList()
        }
        ExpectedArgument.STRING -> {
            listOf(navArgument("value") {
                type = NavType.StringType
            })
        }
    }
}

private fun getScreenPath(destination: Destination): String {
    val argsPath = when (destination.expectedArgument) {
        ExpectedArgument.NO_ARGS -> ""
        ExpectedArgument.STRING -> "/{value}"
    }
    return "${destination.route}${argsPath}"
}

private fun getArgumentPathForNavigation(argument: NavigationArgument): String {
    return when (argument) {
        NoArgument -> ""
        is StringArgument -> "/${argument.value}"
    }
}

fun getRouteForNavigation(navigationEvent: NavigationEvent): String {
    return "${navigationEvent.destination.route}${getArgumentPathForNavigation(navigationEvent.argument)}"
}

fun getScreensMetadataSet(destinationClassSet: Set<Destination>): Set<ScreenMetaData> {
    return destinationClassSet.map {
        ScreenMetaData(
            it,
            getScreenPath(it),
            getArgsList(it)
        )
    }.toSet()
}

fun <R : NavigationArgument> parseDestinationArgs(args: Bundle, requiredDestination: Destination): R {
    val parsedArg: NavigationArgument = when (requiredDestination.expectedArgument) {
        ExpectedArgument.NO_ARGS -> NoArgument
        ExpectedArgument.STRING -> StringArgument(args.getString("value", ""))
    }
    return parsedArg as R
}