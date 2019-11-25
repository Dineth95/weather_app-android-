package com.example.day4.Models

data class Current(
    val observation_time: String?,
    val temperature: Double,
    val weather_code: Double,
    val weather_icons: List<String>?,
    val weather_descriptions: List<String>?,
    val wind_speed: Double,
    val wind_degree: Double,
    val wind_dir: String?,
    val pressure: Double,
    val precip: Double,
    val humidity: Double,
    val cloudcover: Double,
    val feelslike: Double,
    val uv_index: Double,
    val visibility: Double,
    val is_day: String
)
