package com.kodatos.shared

import com.kodatos.shared.di.SharedComponent
import com.kodatos.shared.di.create
import com.kodatos.shared.domain.bookshelf.BookshelfDomainUnit
import com.kodatos.shared.domain.explore.ExploreDomainUnit
import com.kodatos.shared.platform.DomainUnitsProvider
import com.kodatos.shared.platform.SQLProvider
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

abstract class PlatformLayer {

    private lateinit var component: SharedComponent
    lateinit var domainUnitsProvider: DomainUnitsProvider

    fun init(sqlProvider: SQLProvider, bookCacheSize: Int) {
        Napier.base(DebugAntilog())
        component =
            SharedComponent::class.create(SharedComponent.SharedComponentArgs(bookCacheSize))
        initDomainUnitProvider()
    }

    private fun initDomainUnitProvider() {
        domainUnitsProvider = object : DomainUnitsProvider {
            override val exploreDomainUnit: ExploreDomainUnit
                get() = component.exploreDomainUnit
            override val bookshelfDomainUnit: BookshelfDomainUnit
                get() = component.bookshelfDomainUnit

        }
    }

}