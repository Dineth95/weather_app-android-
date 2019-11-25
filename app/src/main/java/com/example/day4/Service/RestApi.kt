package com.example.day4.Service

import com.example.day4.Models.Base
import com.example.day4.Models.Current
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestApi {
    private val restApi:Api
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl("http://api.weatherstack.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        restApi = retrofit.create(Api::class.java)
    }

    fun getCurrentWeather(key:String,city:String): Call<Base>{
        return restApi.getCurrentWeather(key,city)
    }
}