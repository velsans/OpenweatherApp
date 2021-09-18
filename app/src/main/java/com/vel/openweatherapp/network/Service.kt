package com.vel.openweatherapp.network

import com.vel.openweatherapp.OpenWeatherModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherService {
    //@GET("weather?q=Bangalore&appid=8b1a92081780f46922764ad735ae0c86")
    @GET("weather?")
    suspend fun getWeather(
        @Query("q") q: String,
        @Query("appid") appid: String
    ):OpenWeatherModel
}

object OpenWeatherNetwork {

    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        //.baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val OpenWeathers = retrofit.create(OpenWeatherService::class.java)

}


