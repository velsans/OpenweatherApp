package com.vel.openweatherapp

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.work.*

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Velmurugan on 9/14/2021.
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPrefsManager.init(this)
    }
}