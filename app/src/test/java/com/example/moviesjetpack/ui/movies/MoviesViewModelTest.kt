package com.example.moviesjetpack.ui.movies

import androidx.lifecycle.ViewModelProviders
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesjetpack.model.MoviesEntity
import com.example.moviesjetpack.utils.DataDummy
import org.junit.Rule
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock


class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]

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

//    @Test
//    fun setNavigator() {
//        viewModel.setNavigator(x)
//        assertNotNull(viewModel.moviesNavigator)
//    }


    @Test
    fun `getMoviesLiveData$app`() {
        viewModel.setMoviesDummy()
        val moviesEntities = viewModel.getMoviesLiveData()
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities.value?.size)
    }

//    @Test
//    fun itemClick() {
//        viewModel.itemClick(dummyMovie)
//    }


}