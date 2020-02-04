package com.example.moviesjetpack.ui.movies

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.rules.TestRule


class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }
    @Test
    fun `setMoviesDummy$app`() {
        viewModel.setMoviesDummy()
        val moviesEntities = viewModel.listMovies
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities.value?.size)
    }

    @Test
    fun `getMoviesLiveData$app`() {
        viewModel.setMoviesDummy()
        val moviesEntities = viewModel.getMoviesLiveData()
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities.value?.size)
    }

}