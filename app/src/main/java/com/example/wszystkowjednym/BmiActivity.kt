package com.example.wszystkowjednym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_bmi.*

class BmiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        calculate_button.setOnClickListener {
            val weight = weight_input.text.toString().toDouble()
            val height = height_input.text.toString().toDouble()
            calculate_bmi(weight, height, bmi_result)
            bmi_result_text.visibility = TextView.VISIBLE
            infoBmiButton.visibility = TextView.VISIBLE
        }

        clear_data_button.setOnClickListener {
            clear_data(weight_input, height_input, gender_group, bmi_result, bmi_result_text, infoBmiButton)
        }

        }
    }

