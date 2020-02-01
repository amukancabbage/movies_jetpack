package com.example.moviesjetpack.ui.movies

import com.example.moviesjetpack.model.MoviesEntity

interface MoviesNavigator {
    fun onItemClick(moviesEntity: MoviesEntity)
}