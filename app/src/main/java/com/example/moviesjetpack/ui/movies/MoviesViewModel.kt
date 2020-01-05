package com.example.moviesjetpack.ui.movies

import androidx.lifecycle.ViewModel
import com.example.moviesjetpack.data.MoviesEntity
import com.example.moviesjetpack.utils.DataDummy

class MoviesViewModel : ViewModel() {
    fun getMovies(): ArrayList<MoviesEntity> {
        return DataDummy.generateDummyMovies()
    }
}

