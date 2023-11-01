package com.example.wszystkowjednym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlinx.android.synthetic.main.activity_measurement.*

class MeasurementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measurement)

        clearMeasurementButton.setOnClickListener {
            clearMeasurementData(measurementDate, waistMeasurementData, hipsMeasurementData, bellyMeasurementData, thighMeasurementData, chestMeasurementData, armMeasurementData)
        }
    }
}