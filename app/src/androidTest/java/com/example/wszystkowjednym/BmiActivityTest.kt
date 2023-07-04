package com.example.wszystkowjednym

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches



@LargeTest
@RunWith(AndroidJUnit4::class)
class BmiActivityTest {

    private lateinit var scenario: ActivityScenario<BmiActivity>

    @Before
    fun setup() {
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun is_bmi_info_text_displayed() {
        onView(withId(R.id.bmi_info_text)).check(matches(isDisplayed()))
    }

    @Test
    fun is_oblicz_bmi_button_visible_test() {
        onView(withId(R.id.calculate_button)).check(matches(isDisplayed()))
    }

    @Test
    fun is_oblicz_bmi_button_clickable_test() {
        onView(withId(R.id.calculate_button)).check(matches(isClickable()))
    }

    @Test
    fun is_płeć_text_visible_test() {
        onView(withId(R.id.gender_text)).check(matches(isDisplayed()))
    }

    @Test
    fun is_gender_unchecked_test() {
        onView(withId(R.id.female_button)).check(matches(isNotChecked()))
        onView(withId(R.id.male_button)).check(matches(isNotChecked()))
    }

    @Test
    fun is_waga_text_visible_test() {
        onView(withId(R.id.weight_text)).check(matches(isDisplayed()))
    }

    @Test
    fun is_wzrost_text_visible_test() {
        onView(withId(R.id.height_text)).check(matches(isDisplayed()))
    }

    @Test
    fun is_clear_data_button_visible_test() {
        onView(withId(R.id.clear_data_button)).check(matches(isDisplayed()))
    }

    @Test
    fun is_clear_data_button_clickable_test() {
        onView(withId(R.id.clear_data_button)).check(matches(isClickable()))
    }
}