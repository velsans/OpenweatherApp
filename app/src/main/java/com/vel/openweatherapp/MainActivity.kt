package com.vel.openweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vel.openweatherapp.SharedPrefsManager.get
import com.vel.openweatherapp.SharedPrefsManager.set
import com.vel.openweatherapp.workmanager.WorkManagerScheduler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startWorkManager()
    }

    private fun startWorkManager() {
        val isScheduled: Boolean? =
            SharedPrefsManager.customPrefs?.get(Constants.IS_SCHEDULED, false) //getter
        isScheduled?.let { scheduled ->
            if (!scheduled) {
                Log.d("MyWorker", "started scheduler")
                SharedPrefsManager.customPrefs?.set(Constants.IS_SCHEDULED, true) //setter
                WorkManagerScheduler.refreshPeriodicWork(this)
            }
        }
        WorkManagerScheduler.refreshPeriodicWork(this)
    }
}