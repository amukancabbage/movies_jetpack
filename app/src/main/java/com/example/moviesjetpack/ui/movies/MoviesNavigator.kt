package com.example.moviesjetpack.ui.movies

import com.example.moviesjetpack.model.source.local.entity.MoviesEntity

interface MoviesNavigator {
    fun onItemClick(moviesEntity: MoviesEntity)
}