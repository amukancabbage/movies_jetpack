package com.example.moviesjetpack.model.source

import com.example.moviesjetpack.model.source.local.entity.MoviesEntity
import com.example.moviesjetpack.model.source.local.entity.TvEntity
import com.example.moviesjetpack.model.source.remote.RemoteDataSource

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieDataSource {
    override fun getAllMovies(): ArrayList<MoviesEntity> {
        val movieResponse = remoteDataSource.getAllMovies()
        val movieList = ArrayList<MoviesEntity>()
        for (response in movieResponse) {
            val movie = MoviesEntity(
                response.id,
                response.title,
                response.overview,
                response.release_date,
                response.poster_path,
                response.backdrop_path,
                response.vote_average
            )
            movieList.add(movie)
        }
        return movieList
    }

    override fun getAllTvs(): ArrayList<TvEntity> {
        val movieResponse = remoteDataSource.getAllTvs()
        val movieList = ArrayList<TvEntity>()
        for (response in movieResponse) {
            val movie = TvEntity(
                response.id,
                response.name,
                response.overview,
                response.first_air_date,
                response.poster_path,
                response.backdrop_path,
                response.vote_average
            )
            movieList.add(movie)
        }
        return movieList
    }

    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData)
            }
    }
}