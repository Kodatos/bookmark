package com.kodatos.bookmark.di

import com.kodatos.shared.domain.explore.ExploreAction
import com.kodatos.shared.domain.explore.ExploreState
import com.kodatos.shared.domain.unit.DomainUnit
import com.kodatos.shared.platform.AndroidPlatformLayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object SharedViewModelsModule {

    @Provides
    fun exploreDomainUnit(): DomainUnit<ExploreState, ExploreAction> =
        AndroidPlatformLayer.exploreDomainUnit
}