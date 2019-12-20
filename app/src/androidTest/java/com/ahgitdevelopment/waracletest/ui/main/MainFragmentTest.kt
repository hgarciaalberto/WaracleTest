package com.ahgitdevelopment.waracletest.ui.main

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ahgitdevelopment.waracletest.R
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    @Test
    fun load_Cake_List_When_Running_The_App() {
        val scenario =
            launchFragmentInContainer<MainFragment>(null, R.style.AppTheme, null)

        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }

    @Test
    fun show_list_when_recreating_the_app() {

        val scenario =
            launchFragmentInContainer<MainFragment>(null, R.style.AppTheme, null)

        scenario.recreate()
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
    }
}