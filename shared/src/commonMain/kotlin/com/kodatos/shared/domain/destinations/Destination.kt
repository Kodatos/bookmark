package com.kodatos.shared.domain.destinations

enum class Destination(val route: String, val expectedArgument: ExpectedArgument) {
    EXPLORE("explore", ExpectedArgument.NO_ARGS),
    BOOKSHELF("bookshelf", ExpectedArgument.NO_ARGS)
}

enum class ExpectedArgument {
    NO_ARGS,
    STRING
}

