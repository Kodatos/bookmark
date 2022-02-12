package com.kodatos.shared.platform

import com.kodatos.shared.domain.explore.ExploreDomainUnit

interface DomainUnitsProvider {
    val exploreDomainUnit: ExploreDomainUnit
}