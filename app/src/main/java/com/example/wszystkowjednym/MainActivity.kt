package com.example.wszystkowjednym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bmi_button.setOnClickListener {
            var new_activity : Intent = Intent(applicationContext, BmiActivity::class.java)
            startActivity(new_activity)
        }

        measurement_button.setOnClickListener {
            var new_activity : Intent = Intent(applicationContext, MeasurementActivity::class.java)
            startActivity(new_activity)
        }


    }
}