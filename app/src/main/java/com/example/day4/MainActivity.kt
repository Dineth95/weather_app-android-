package com.example.day4

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.erkutaras.statelayout.StateLayout
import com.example.day4.Models.Base
import com.example.day4.Service.ApiManager
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity(),AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById<Spinner>(R.id.spinner)
        val stateLayout = findViewById<StateLayout>(R.id.stateLayout)
        val textview1=findViewById<TextView>(R.id.txt1)
        
        //Please attach your api key here
        var Your_APi_key:String=""

// Create an ArrayAdapter using the string array and a default spinner layout
        stateLayout.content()
        ArrayAdapter.createFromResource(
            this,
            R.array.spinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        var manager = ApiManager()

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                stateLayout.loading()

                //stateLayout.content()
                try {
                    val observable=manager.getWeather("Your_APi_key",selectedItem)
                    observable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe({base->setValues(base)})
                    stateLayout.content()
                }catch (e: Exception){
                    Log.d("Error","Error occured")
                    stateLayout.content()
                }

            } // to close the onItemSelected

            override fun onNothingSelected(parent: AdapterView<*>) {

            }

            fun setValues(base:Base){
                textview1.setText(base.current.temperature.toString())
                txtWind.setText("Wind: "+base.current.wind_speed.toString())
                txtHumidity.setText("Humidity: "+base.current.humidity.toString())
            }
        }
    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {
    }
}
