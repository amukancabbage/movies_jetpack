package com.example.moviesjetpack.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
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

    @Mock
    private lateinit var observer: Observer<List<TvEntity>>

    @Before
    fun setUp() {
        viewModel = TvViewModel(movieRepository)
    }

    @Test
    fun `setTvDummy$app`() {
        viewModel.setTvDummy()
        val tvEntities = viewModel.listTv
        assertNotNull(tvEntities)
        assertEquals(12, tvEntities.value?.size)
    }

    @Test
    fun `getTvLiveData$app`() {
        viewModel.setTvDummy()
        val tvEntities = viewModel.getTvLiveData()
        assertNotNull(tvEntities)
        assertEquals(12, tvEntities.value?.size)
    }

    @Test
    fun getTvs(){

        val dummyCourses = DataDummy.generateDummyTvs()
        val tvs = MutableLiveData<ArrayList<TvEntity>>()
        tvs.value = dummyCourses

        Mockito.`when`(movieRepository.getAllTvs()).thenReturn(tvs)
        viewModel.getTvs()
        val tvsEntities = viewModel.listTv
        Mockito.verify<MovieRepository>(movieRepository).getAllTvs()
        assertNotNull(tvsEntities)
        assertEquals(12, tvsEntities.value?.size)

        viewModel.listTv.observeForever(observer)
        Mockito.verify(observer).onChanged(dummyCourses)

    }
}