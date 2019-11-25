package com.example.day4

import android.os.AsyncTask
import java.util.*

interface LoadingImplementation{
    fun onFinishedLoading()
}

/*
class LoadingAsync(private val listener: LoadingImplementation): AsyncTask<Void, Void, Void>(){
    override fun doInBackground(vararg params: Void?):Void{
        for (i in 0 until 10) {
            Thread.sleep(1000)
        }
    }

    override fun onPostExecute(result: Void?){
        super.onPostExecute(result)
        listener.onFinishedLoading()
    }
}*/
