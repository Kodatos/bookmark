package com.kodatos.shared

import com.kodatos.shared.di.SharedComponent
import com.kodatos.shared.di.create
import com.kodatos.shared.domain.destinations.Destination
import com.kodatos.shared.domain.destinations.ExploreDestination
import com.kodatos.shared.platform.SQLProvider
import kotlin.reflect.KClass

abstract class PlatformLayer {

    private lateinit var component: SharedComponent
    val exploreDomainUnit by component::exploreDomainUnit

    fun init(sqlProvider: SQLProvider, bookCacheSize: Int) {
        component = SharedComponent::class.create(SharedComponent.SharedComponentArgs(bookCacheSize))
    }

    fun getDestinationsList(): List<KClass<out Destination<*>>> {
        return listOf(ExploreDestination::class)
    }

}