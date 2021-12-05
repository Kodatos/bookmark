package com.kodatos.shared.platform

import android.content.Context
import com.kodatos.shared.PlatformLayer

object AndroidPlatformLayer: PlatformLayer() {

    fun init(context: Context, booksCacheSize: Int) {
        val sqlProvider = SQLProvider(context)
        super.init(sqlProvider, booksCacheSize)
    }
}