package com.example.moviesjetpack.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesjetpack.model.source.MovieRepository
import com.example.moviesjetpack.model.source.local.entity.MoviesEntity
import com.example.moviesjetpack.model.source.local.entity.TvEntity
import com.example.moviesjetpack.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvViewModelTest {

    private lateinit var viewModel: TvViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = TvViewModel(movieRepository)
    }

    @Test
    fun `setTvDummy$app`() {
        viewModel.setTvDummy()
        val tvEntities = viewModel.listTv
        assertNotNull(tvEntities)
        assertEquals(11, tvEntities.value?.size)
    }

    @Test
    fun `getTvLiveData$app`() {
        viewModel.setTvDummy()
        val tvEntities = viewModel.getTvLiveData()
        assertNotNull(tvEntities)
        assertEquals(11, tvEntities.value?.size)
    }

    @Test
    fun getTvs(){
        Mockito.`when`<ArrayList<TvEntity>>(movieRepository.getAllTvs()).thenReturn(DataDummy.generateDummyTvs())
        viewModel.getTvs()
        val tvEntities = viewModel.listTv
        Mockito.verify<MovieRepository>(movieRepository).getAllTvs()
        assertNotNull(tvEntities)
        assertEquals(11, tvEntities.value?.size)
    }
}