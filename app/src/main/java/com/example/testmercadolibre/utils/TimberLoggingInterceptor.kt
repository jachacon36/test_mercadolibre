package com.example.testmercadolibre.utils

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class TimberLoggingInterceptor : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Timber.d(message)
    }
}