package com.kodatos.shared

import com.kodatos.shared.di.SharedComponent
import com.kodatos.shared.di.create

object PlatformLayer {

    private lateinit var component: SharedComponent

    fun init() {
        component = SharedComponent::class.create()
    }
}