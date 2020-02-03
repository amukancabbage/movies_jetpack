package com.example.moviesjetpack.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.moviesjetpack.R
import com.example.moviesjetpack.utils.DataDummy
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest{

    private val dummyMovies = DataDummy.generateDummyMovies()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }


    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.td_title)).check(matches(isDisplayed()))
        onView(withId(R.id.td_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.td_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.td_release_date)).check(matches(withText(dummyMovies[0].release_date)))
        onView(withId(R.id.td_description)).check(matches(isDisplayed()))
        onView(withId(R.id.td_description)).check(matches(withText(dummyMovies[0].overview)))
    }

//    @Test
//    fun loadModule() {
//        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.btn_start)).perform(click())
//        onView(withId(R.id.rv_module)).check(matches(isDisplayed()))
//    }
//
//    @Test
//    fun loadDetailModule() {
//        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.btn_start)).perform(click())
//        onView(withId(R.id.rv_module)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
//        onView(withId(R.id.web_view)).check(matches(isDisplayed()))
//    }
//
//    @Test
//    fun loadBookmarks() {
//        onView(withText("Bookmark")).perform(click())
//        onView(withId(R.id.rv_bookmark)).check(matches(isDisplayed()))
//        onView(withId(R.id.rv_bookmark)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
//    }
}