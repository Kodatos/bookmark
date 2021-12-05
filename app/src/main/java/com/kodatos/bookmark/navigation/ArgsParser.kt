package com.kodatos.bookmark.navigation

import android.os.Bundle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.kodatos.shared.domain.common.Result
import com.kodatos.shared.domain.destinations.DestinationArg
import com.kodatos.shared.domain.destinations.EmptyArgs
import com.kodatos.shared.domain.destinations.StringArg
import java.lang.IllegalArgumentException

inline fun <reified R: DestinationArg> parseDestinationArgs(args: Bundle, expectedType: DestinationArgType): Result<R, Exception> {
    val parsedArg = when(expectedType) {
        DestinationArgType.STRING -> StringArg(args.getString("value")!!)
        DestinationArgType.EMPTY -> EmptyArgs
    }
    return if(R::class.isInstance(parsedArg)){
        Result.SUCCESS(parsedArg as R)
    } else {
        Result.ERROR(IllegalArgumentException("Expected argument type mismatches type parameter"))
    }
}

sealed class DestinationArgType(val argsRoute: String, val argsList: List<NamedNavArgument>) {
    object EMPTY: DestinationArgType("", emptyList())
    object STRING: DestinationArgType("/{value}", listOf(navArgument("value"){
        type = NavType.StringType
    }))
}