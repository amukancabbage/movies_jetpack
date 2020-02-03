package com.example.moviesjetpack.ui.home

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.moviesjetpack.utils.DataDummy
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestActivityTest{
    private val dummyMovies = DataDummy.generateDummyMovies()

//    @get:Rule
//    var activityRule = ActivityTestRule(TestActivity::class.java)

    @Test
    fun show() {
//        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()))
//        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(TestActivity::class.java)
    }

}