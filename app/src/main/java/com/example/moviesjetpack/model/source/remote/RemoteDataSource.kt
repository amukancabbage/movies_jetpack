package com.example.moviesjetpack.model.source.remote

import com.example.moviesjetpack.model.source.remote.response.MovieResponse
import com.example.moviesjetpack.model.source.remote.response.TvResponse
import com.example.moviesjetpack.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovies(): List<MovieResponse> = jsonHelper.loadMovies()
    fun getAllTvs(): List<TvResponse> = jsonHelper.loadTvs()

}