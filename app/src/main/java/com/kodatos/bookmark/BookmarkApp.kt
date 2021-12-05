package com.kodatos.bookmark

import android.app.Application
import com.kodatos.shared.platform.AndroidPlatformLayer
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BookmarkApp : Application() {

    private val CACHE_SIZE = 50

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        AndroidPlatformLayer.init(applicationContext, CACHE_SIZE)
    }
}
