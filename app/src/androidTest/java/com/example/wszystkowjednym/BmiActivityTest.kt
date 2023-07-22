package com.example.wszystkowjednym

import android.content.Intent
import android.drm.DrmStore
import android.net.Uri
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.*
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not


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
    fun is_calculate_bmi_button_visible_test() {
        onView(withId(R.id.calculate_button)).check(matches(isDisplayed()))
    }

    @Test
    fun is_calculate_bmi_button_clickable_test() {
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
    fun is_weight_text_visible_test() {
        onView(withId(R.id.weight_text)).check(matches(isDisplayed()))
    }

    @Test
    fun is_height_text_visible_test() {
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

    @Test
    fun is_only_one_gender_selected_test() {
        onView(withId(R.id.female_button)).perform(click())
        onView(withId(R.id.male_button)).perform(click())
        onView(withId(R.id.female_button)).check(matches(isNotChecked()))
    }

    @Test
    fun is_height_input_accept_max_three_characters_test() {
        val height = "1111"
        onView(withId(R.id.height_input)).perform(typeText(height)).perform(closeSoftKeyboard())
        onView(withId(R.id.height_input)).check(matches(withText("111")))
    }

    @Test
    fun is_height_input_not_accept_letters_test() {
        val letters = "ABC"
        onView(withId(R.id.height_input)).perform(typeText(letters)).perform(closeSoftKeyboard())
        onView(withId(R.id.height_input)).check(matches(withText("")))
    }

    @Test
    fun is_weight_input_accept_max_three_characters_test() {
        val height = "1111"
        onView(withId(R.id.weight_input)).perform(typeText(height)).perform(closeSoftKeyboard())
        onView(withId(R.id.weight_input)).check(matches(withText("111")))
    }

    @Test
    fun is_weight_input_not_accept_letters_test() {
        val letters = "ABC"
        onView(withId(R.id.weight_input)).perform(typeText(letters)).perform(closeSoftKeyboard())
        onView(withId(R.id.weight_input)).check(matches(withText("")))
    }

    @Test
    fun is_clear_data_button_clears_data_test() {
        onView(withId(R.id.female_button)).perform(click())
        onView(withId(R.id.weight_input)).perform(typeText("60"))
        onView(withId(R.id.height_input)).perform(typeText("160")).perform(closeSoftKeyboard())
        onView(withId(R.id.clear_data_button)).perform(click())
        onView(withId(R.id.female_button)).check(matches(isNotChecked()))
        onView(withId(R.id.male_button)).check(matches(isNotChecked()))
        onView(withId(R.id.weight_input)).check(matches(withText("")))
        onView(withId(R.id.height_input)).check(matches(withText("")))

    }

    @Test
    fun is_gender_weight_height_validation_display_error_info_test() {
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.gender_error_info)).check(matches(isDisplayed()))
        onView(withId(R.id.weight_error_info)).check(matches(isDisplayed()))
        onView(withId(R.id.height_error_info)).check(matches(isDisplayed()))
    }

    @Test
    fun is_clear_data_button_hide_validation_error_test() {
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.clear_data_button)).perform(click())
        onView(withId(R.id.gender_error_info)).check(matches(not(isDisplayed())))
        onView(withId(R.id.weight_error_info)).check(matches(not(isDisplayed())))
        onView(withId(R.id.height_error_info)).check(matches(not(isDisplayed())))
    }

    @Test
    fun is_weight_error_disappear_after_entered_weight_test() {
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.weight_input)).perform(typeText("45"))
        onView(withId(R.id.weight_error_info)).check(matches(not(isDisplayed())))
    }

    @Test
    fun is_height_error_disappear_after_entered_height_test() {
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.height_input)).perform(typeText("150"))
        onView(withId(R.id.height_error_info)).check(matches(not(isDisplayed())))
    }

    @Test
    fun is_gender_error_disappear_after_click_gender_test() {
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.female_button)).perform(click())
        onView(withId(R.id.gender_error_info)).check(matches(not(isDisplayed())))
    }

    @Test
    fun is_bmi_link_info_displayed_test() {
        onView(withId(R.id.bmi_link_info)).check(matches(isDisplayed()))
    }

    @Test
    fun is_bmi_link_displayed_test() {
        onView(withId(R.id.female_button)).perform(click())
        onView(withId(R.id.weight_input)).perform(typeText("60"))
        onView(withId(R.id.height_input)).perform(typeText("160"))
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.bmi_link)).check(matches(isDisplayed()))
    }

    @Test
    fun is_bmi_link_opened_website_test() {
        Intents.init()
        val website = "https://pl.wikipedia.org/wiki/Wska%C5%BAnik_masy_cia%C5%82a"
        onView(withId(R.id.female_button)).perform(click())
        onView(withId(R.id.weight_input)).perform(typeText("60"))
        onView(withId(R.id.height_input)).perform(typeText("160"), closeSoftKeyboard())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.bmi_link)).check(matches(isClickable()))
        onView(withId(R.id.bmi_link)).perform(click())
        Thread.sleep(1000)
        intended(allOf(
            hasAction(Intent.ACTION_VIEW),
            hasData(Uri.parse(website))
        ))
        Intents.release()
    }




}