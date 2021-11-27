package com.kodatos.shared

import com.kodatos.shared.di.SharedComponent
import com.kodatos.shared.di.create

object PlatformLayer {

    private lateinit var component: SharedComponent

    fun init(bookCacheSize: Int) {
        component = SharedComponent::class.create(SharedComponent.SharedComponentArgs(50))
    }
}