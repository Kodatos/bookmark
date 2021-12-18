package com.kodatos.bookmark.navigation

import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.kodatos.shared.domain.destinations.*
import com.kodatos.shared.domain.unit.event.NavEvent

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

fun getRouteForNavigation(navEvent: NavEvent): String {
    return "${navEvent.destination.route}${getArgumentPathForNavigation(navEvent.argument)}"
}

fun getScreensMetadataList(destinationClassList: List<Destination>): List<ScreenMetaData> {
    return destinationClassList.map {
        ScreenMetaData(
            getScreenPath(it),
            getArgsList(it)
        )
    }
}

fun <R : NavigationArgument> parseDestinationArgs(args: Bundle, argument: ExpectedArgument): R {
    val parsedArg: NavigationArgument = when (argument) {
        ExpectedArgument.NO_ARGS -> NoArgument
        ExpectedArgument.STRING -> StringArgument(args.getString("value", ""))
    }
    return parsedArg as R
}