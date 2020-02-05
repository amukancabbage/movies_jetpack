package com.example.moviesjetpack.ui.movies

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesjetpack.model.source.MovieRepository
import com.example.moviesjetpack.model.source.local.entity.MoviesEntity
import com.example.moviesjetpack.utils.DataDummy
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(movieRepository)
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

    @Test
    fun getMovies(){
        `when`<ArrayList<MoviesEntity>>(movieRepository.getAllMovies()).thenReturn(DataDummy.generateDummyMovies())
        viewModel.getMovies()
        val moviesEntities = viewModel.listMovies
        verify<MovieRepository>(movieRepository).getAllMovies()
        assertNotNull(moviesEntities)
        assertEquals(11, moviesEntities.value?.size)

    }

}