package com.example.moviesjetpack.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.moviesjetpack.R
import com.example.moviesjetpack.utils.DataDummy
import com.example.moviesjetpack.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest{

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvs = DataDummy.generateDummyTvs()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }
    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

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
        onView(withId(R.id.td_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.td_rating)).check(matches(withText(dummyMovies[0].vote_average)))
    }

    @Test
    fun loadTvs() {
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(withId(R.id.recyclerViewTv)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewTv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvs.size))
    }

    @Test
    fun loadDetailTv() {
        onView(withId(R.id.action_bookmark)).perform(click())
        onView(withId(R.id.recyclerViewTv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tvd_tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tvd_tv_title)).check(matches(withText(dummyTvs[0].name)))
        onView(withId(R.id.tvd_tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tvd_tv_release_date)).check(matches(withText(dummyTvs[0].first_air_date)))
        onView(withId(R.id.tvd_tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvd_tv_overview)).check(matches(withText(dummyTvs[0].overview)))
        onView(withId(R.id.tvd_tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvd_tv_rating)).check(matches(withText(dummyTvs[0].vote_average)))
    }

}