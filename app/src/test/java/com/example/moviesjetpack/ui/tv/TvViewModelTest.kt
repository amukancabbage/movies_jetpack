package com.example.moviesjetpack.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class TvViewModelTest {

    private lateinit var viewModel: TvViewModel

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = TvViewModel()
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
}