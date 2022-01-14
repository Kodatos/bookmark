package com.kodatos.bookmark.di

import com.kodatos.bookmark.helper.DispatcherProvider
import com.kodatos.bookmark.helper.EventChannelProducer
import com.kodatos.bookmark.helper.EventConsumer
import com.kodatos.bookmark.helper.EventManager
import com.kodatos.shared.platform.AndroidPlatformLayer
import com.kodatos.shared.platform.DomainUnitsProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
interface SharedSingletonModule {

    @Binds
    fun bindsEventConsumer(eventManager: EventManager): EventConsumer

    @Binds
    fun bindsEventChannelProducer(eventManager: EventManager): EventChannelProducer


    companion object {
        @Provides
        fun providesDispatcherProvider(): DispatcherProvider = object : DispatcherProvider {
            override val MAIN: CoroutineDispatcher
                get() = Dispatchers.Main
            override val IO: CoroutineDispatcher
                get() = Dispatchers.IO
            override val DEFAULT: CoroutineDispatcher
                get() = Dispatchers.Default

        }

        @Provides
        fun providesDomainUnitProvider(): DomainUnitsProvider = AndroidPlatformLayer.domainUnitsProvider
    }
}