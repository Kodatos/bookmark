package com.kodatos.shared.domain.destinations

sealed interface NavigationArgument {
    override fun toString(): String
}

class StringArgument(val value: String): NavigationArgument {
    override fun toString() = value
}

object NoArgument: NavigationArgument {
    override fun toString() = "no arguments"

}