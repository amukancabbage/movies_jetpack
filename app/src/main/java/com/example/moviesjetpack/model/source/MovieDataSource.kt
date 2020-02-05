package com.example.moviesjetpack.model.source

import com.example.moviesjetpack.model.source.local.entity.MoviesEntity
import com.example.moviesjetpack.model.source.local.entity.TvEntity

interface MovieDataSource {

    fun getAllMovies(): List<MoviesEntity>
    fun getAllTvs(): List<TvEntity>

}