package com.kodatos.shared

import com.kodatos.shared.di.SharedComponent
import com.kodatos.shared.di.create
import com.kodatos.shared.domain.destinations.Destination
import com.kodatos.shared.domain.explore.ExploreAction
import com.kodatos.shared.domain.explore.ExploreState
import com.kodatos.shared.domain.unit.DomainUnit
import com.kodatos.shared.platform.DomainUnitsProvider
import com.kodatos.shared.platform.SQLProvider

abstract class PlatformLayer {

    private lateinit var component: SharedComponent
    lateinit var domainUnitsProvider: DomainUnitsProvider

    fun init(sqlProvider: SQLProvider, bookCacheSize: Int) {
        component = SharedComponent::class.create(SharedComponent.SharedComponentArgs(bookCacheSize))
        domainUnitsProvider = object : DomainUnitsProvider {
            override val exploreDomainUnit: DomainUnit<ExploreState, ExploreAction>
                get() = component.exploreDomainUnit

        }
    }

    fun getDestinationsList(): List<Destination> {
        return listOf(Destination.EXPLORE)
    }

}