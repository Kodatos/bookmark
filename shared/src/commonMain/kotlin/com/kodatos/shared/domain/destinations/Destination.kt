package com.kodatos.shared.domain.destinations


sealed class Destination<T : DestinationArg>(
    val route: String,
    val arguments: T
)

sealed class NoArgsDestination(route: String) : Destination<EmptyArgs>(route, EmptyArgs)

sealed interface DestinationArg

object EmptyArgs : DestinationArg
class StringArg(value: String): DestinationArg
