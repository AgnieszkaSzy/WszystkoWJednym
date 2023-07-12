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
                var weight = weight_input.text.toString().toDouble()
                var height = height_input.text.toString().toDouble()
                var bmi: Double = weight/(height*height*0.0001)
                calculate_bmi(weight, height, bmi_result)
                interpret_bmi_result(bmi, result_interpretation)
                display_bmi_information(bmi_result_text, bmi_result, result_interpretation, bmi_link_info, bmi_link )


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
            clear_data(weight_input, height_input, gender_group, gender_error_info, weight_error_info, height_error_info)
            hide_bmi_information(bmi_result_text, bmi_result, result_interpretation, bmi_link_info, bmi_link )
        }

        }
    }

