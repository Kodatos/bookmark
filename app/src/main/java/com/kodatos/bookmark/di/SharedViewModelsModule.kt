package com.kodatos.bookmark.di

import com.kodatos.shared.domain.explore.ExploreDomainUnit
import com.kodatos.shared.platform.DomainUnitsProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SharedViewModelsModule {

    @Provides
    fun exploreDomainUnit(domainUnitsProvider: DomainUnitsProvider): ExploreDomainUnit =
        domainUnitsProvider.exploreDomainUnit
}