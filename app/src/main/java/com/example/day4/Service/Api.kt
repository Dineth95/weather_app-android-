package com.example.day4.Service

import com.example.day4.Models.Base
import retrofit2.Call
import com.example.day4.Models.Current
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Api {
    @GET("/current")
    fun getCurrentWeather(
        @Query("access_key") access_key:String,
        @Query("query") query:String
    ): Call<Base>
}