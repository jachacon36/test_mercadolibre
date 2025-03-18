package com.example.testmercadolibre.application
import timber.log.Timber

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MLApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
