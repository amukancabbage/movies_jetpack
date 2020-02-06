package com.example.moviesjetpack.model.source

import androidx.lifecycle.LiveData
import com.example.moviesjetpack.model.source.local.entity.MoviesEntity
import com.example.moviesjetpack.model.source.local.entity.TvEntity

interface MovieDataSource {

    fun getAllMovies(): LiveData<ArrayList<MoviesEntity>>
    fun getAllTvs(): LiveData<ArrayList<TvEntity>>
    fun getAllMoviesArrayList(): ArrayList<MoviesEntity>
    fun getAllTvsArrayList(): ArrayList<TvEntity>

}