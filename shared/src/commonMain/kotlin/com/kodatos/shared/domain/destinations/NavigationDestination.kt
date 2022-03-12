package com.kodatos.shared.domain.destinations

sealed class NavigationDestination(val route: String) {
    class Explore : NavigationDestination("explore")
    class Bookshelf : NavigationDestination("bookshelf")
}

