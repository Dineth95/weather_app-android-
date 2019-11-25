package com.example.day4.Service

import com.example.day4.Models.Base
import com.example.day4.Models.Current
import io.reactivex.Observable


class ApiManager(private val api:RestApi= RestApi()){
    fun getWeather(key:String,query:String):Observable<Base>{
        return Observable.create<Base>{
            val callResponse=api.getCurrentWeather(key,query)
            val response=callResponse.execute()
            val base = response.body() as Base
            it.onNext(base)
            it.onComplete()
        }
    }
}