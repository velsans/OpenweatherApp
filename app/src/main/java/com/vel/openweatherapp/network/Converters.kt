package com.vel.openweatherapp.network

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vel.openweatherapp.*

/**
 * Created by Velmurugan on 9/17/2021.
 */
class Converters {
    @TypeConverter
    fun fromCloudsList(value: Clouds): String {
        val gson = Gson()
        val type = object : TypeToken<Clouds>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toListClouds(value: String): Clouds {
        val gson = Gson()
        val type = object : TypeToken<Clouds>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromCoordList(value: Coord): String {
        val gson = Gson()
        val type = object : TypeToken<Coord>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toListCoord(value: String): Coord {
        val gson = Gson()
        val type = object : TypeToken<Coord>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromMainList(value: Main): String {
        val gson = Gson()
        val type = object : TypeToken<Main>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toListMain(value: String): Main {
        val gson = Gson()
        val type = object : TypeToken<Main>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromSysList(value: Sys): String {
        val gson = Gson()
        val type = object : TypeToken<Sys>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toSysList(value: String): Sys {
        val gson = Gson()
        val type = object : TypeToken<Sys>() {}.type
        return gson.fromJson(value, type)
    }


    @TypeConverter
    fun fromCountryLangList(value: List<Weather>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Weather>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCountryLangList(value: String): List<Weather> {
        val gson = Gson()
        val type = object : TypeToken<List<Weather>>() {}.type
        return gson.fromJson(value, type)
    }


    @TypeConverter
    fun fromWindsList(value: Wind): String {
        val gson = Gson()
        val type = object : TypeToken<Wind>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toWind(value: String): Wind {
        val gson = Gson()
        val type = object : TypeToken<Wind>() {}.type
        return gson.fromJson(value, type)
    }


}