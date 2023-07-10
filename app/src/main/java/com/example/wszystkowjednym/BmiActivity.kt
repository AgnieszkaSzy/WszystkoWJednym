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

            if ((female_button.isChecked or male_button.isChecked) && weight_input.length()>0 && height_input.length()>0) {
                gender_error_info.visibility = TextView.INVISIBLE
                weight_error_info.visibility = TextView.INVISIBLE
                height_error_info.visibility = TextView.INVISIBLE
                val weight = weight_input.text.toString().toDouble()
                val height = height_input.text.toString().toDouble()
                calculate_bmi(weight, height, bmi_result)
                bmi_result_text.visibility = TextView.VISIBLE
                infoBmiButton.visibility = TextView.VISIBLE
            } else {
                if (!female_button.isChecked and !male_button.isChecked) {
                    gender_error_info.visibility = TextView.VISIBLE} else {
                        gender_error_info.visibility = TextView.INVISIBLE}
                if (weight_input.length() == 0) {
                    weight_error_info.visibility = TextView.VISIBLE} else {
                        weight_error_info.visibility = TextView.INVISIBLE}
                if (height_input.length() == 0) {
                    height_error_info.visibility = TextView.VISIBLE} else {
                        height_error_info.visibility = TextView.INVISIBLE
                    }
            }
        }

        clear_data_button.setOnClickListener {
            clear_data(weight_input, height_input, gender_group, bmi_result, bmi_result_text, infoBmiButton)
        }

        }
    }

