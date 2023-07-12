package com.example.wszystkowjednym

import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

fun calculate_bmi(weight: Double, height: Double, bmi_result: TextView) {
    var bmi = weight/(height*height*0.0001)
    bmi_result.setText(round_bmi(bmi).toString())
}

fun round_bmi(bmi: Double) : Double {
    var bigDecimal = BigDecimal(bmi).setScale(1, RoundingMode.HALF_UP )
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

fun interpret_bmi_result (bmi: Double, result_interpretation: TextView) {
    if (bmi < 16) {result_interpretation.setText(R.string.bmi_less_than_16)}
    else if (bmi >= 16 && bmi < 17) {result_interpretation.setText(R.string.bmi_from_16_to_16_99)}
    else if (bmi >= 17 && bmi < 18.5) {result_interpretation.setText(R.string.bmi_from_17_to_18_49)}
    else if (bmi >= 18.5 && bmi < 25) {result_interpretation.setText(R.string.bmi_from_18_5_to_24_99)}
    else if (bmi >= 25 && bmi < 30) {result_interpretation.setText(R.string.bmi_from_25_to_29_99)}
    else if (bmi >= 30 && bmi < 35) {result_interpretation.setText(R.string.bmi_from_30_to_34_99)}
    else if (bmi >= 35 && bmi < 40) {result_interpretation.setText(R.string.bmi_from_35_to_39_99)}
    else if (bmi >= 40) {result_interpretation.setText(R.string.bmi_more_than_40)}
    else {"Błędne dane"}
}