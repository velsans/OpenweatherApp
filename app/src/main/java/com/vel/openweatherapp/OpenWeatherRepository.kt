package com.vel.openweatherapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vel.openweatherapp.network.OpenWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class OpenWeatherRepository {

    private val _weather = MutableLiveData<OpenWeatherModel>()

    val weather: LiveData<OpenWeatherModel>
        get() = _weather

    suspend fun refreshWeather(location: String) {
        withContext(Dispatchers.IO) {
            try {
                val weatherlist =
                    OpenWeatherNetwork.OpenWeathers.getWeather(location, "8b1a92081780f46922764ad735ae0c86")
                _weather.postValue(weatherlist)
            } catch (e: Exception) {
                Timber.d("refresh Exception" + e.toString())
            }

        }
    }
}
