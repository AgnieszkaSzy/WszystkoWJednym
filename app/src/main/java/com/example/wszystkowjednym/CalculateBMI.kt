package com.example.wszystkowjednym

import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

fun calculate_bmi(weight: Double, height: Double, bmi_result: TextView) {
    val bmi = weight/(height*height*0.0001)
    bmi_result.setText(round_bmi(bmi).toString())
}

fun round_bmi(bmi: Double) : Double {
    val bigDecimal = BigDecimal(bmi).setScale(1, RoundingMode.HALF_UP )
    return bigDecimal.toDouble()
}

fun display_bmi_information(bmi_result_text: TextView, bmi_result: TextView, result_interpretation: TextView, bmi_link_info: TextView, bmi_link: ImageButton) {
    bmi_result_text.visibility = TextView.VISIBLE
    bmi_result.visibility = TextView.VISIBLE
    result_interpretation.visibility = TextView.VISIBLE
    bmi_link_info.visibility = TextView.VISIBLE
    bmi_link.visibility = TextView.VISIBLE
}

fun hide_bmi_information(bmi_result_text: TextView, bmi_result: TextView, result_interpretation: TextView, bmi_link_info: TextView, bmi_link: ImageButton) {
    bmi_result_text.visibility = TextView.INVISIBLE
    bmi_result.visibility = TextView.INVISIBLE
    result_interpretation.visibility = TextView.INVISIBLE
    bmi_link_info.visibility = TextView.INVISIBLE
    bmi_link.visibility = TextView.INVISIBLE
}

fun clear_data (weight: TextView, height: TextView, gender: RadioGroup, gender_error_info: TextView, weight_error_info: TextView, height_error_info: TextView) {
    weight.setText("")
    height.setText("")
    gender.clearCheck()
    gender_error_info.visibility = TextView.INVISIBLE
    weight_error_info.visibility = TextView.INVISIBLE
    height_error_info.visibility = TextView.INVISIBLE

}