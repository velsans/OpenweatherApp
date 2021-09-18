/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vel.openweatherapp

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.io.IOException

class OpenWeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val _weatherRepository = OpenWeatherRepository()
    val weatherList = _weatherRepository.weather

    init {
        refreshDataFromRepository(Constants.currentLocation)
    }

    fun refreshDataFromRepository(location: String) {
        Constants.currentLocation = if (location.isNullOrBlank() || location.isNullOrEmpty())
            "Bengaluru"
        else
            location
        viewModelScope.launch {
            try {
                _weatherRepository.refreshWeather(Constants.currentLocation)
            } catch (networkError: IOException) {
            }
        }
    }


    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(OpenWeatherViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return OpenWeatherViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
