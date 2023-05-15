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
    bmi_result.visibility = TextView.VISIBLE


}

fun round_bmi(bmi: Double) : Double {
    val bigDecimal = BigDecimal(bmi).setScale(1, RoundingMode.HALF_UP )
    return bigDecimal.toDouble()
}

fun clear_data (weight: TextView, height: TextView, gender: RadioGroup, bmi_result: TextView, bmi_result_text: TextView, infoBmiButton: ImageButton) {
    weight.setText("")
    height.setText("")
    gender.clearCheck()
    bmi_result.setText("")
    bmi_result_text.visibility = TextView.INVISIBLE
    infoBmiButton.visibility = ImageButton.INVISIBLE
}