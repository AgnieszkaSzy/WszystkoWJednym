package com.example.wszystkowjednym

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = launchActivity()
        scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun is_welcome_text_displayed_test() {
        onView(withId(R.id.welcome_text)).check(matches(isDisplayed()))
    }

    @Test
    fun is_choice_text_displayed_test() {
        onView(withId(R.id.choice_text)).check(matches(isDisplayed()))
    }

    @Test
    fun is_main_activity_visible_test() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun open_activity_bmi_test() {
        onView(withId(R.id.bmi_button)).perform(click())
        onView(withId(R.id.activity_bmi)).check(matches(isDisplayed()))
    }

    @Test
    fun open_activity_measurement_test() {
        onView(withId(R.id.measurement_button)).perform(click())
        onView(withId(R.id.measurement_activity)).check(matches(isDisplayed()))
    }

}