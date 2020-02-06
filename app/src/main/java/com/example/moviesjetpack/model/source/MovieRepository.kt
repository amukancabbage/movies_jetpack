package com.example.moviesjetpack.model.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesjetpack.model.source.local.entity.MoviesEntity
import com.example.moviesjetpack.model.source.local.entity.TvEntity
import com.example.moviesjetpack.model.source.remote.RemoteDataSource
import com.example.moviesjetpack.model.source.remote.response.MovieResponse
import com.example.moviesjetpack.model.source.remote.response.TvResponse

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieDataSource {

    override fun getAllMoviesArrayList(): ArrayList<MoviesEntity> {
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

    override fun getAllTvsArrayList(): ArrayList<TvEntity> {
        val tvResponse = remoteDataSource.getAllTvs()
        val tvList = ArrayList<TvEntity>()
        for (response in tvResponse) {
            val tv = TvEntity(
                response.id,
                response.name,
                response.overview,
                response.first_air_date,
                response.poster_path,
                response.backdrop_path,
                response.vote_average
            )
            tvList.add(tv)
        }
        return tvList
    }


    override fun getAllMovies(): MutableLiveData<ArrayList<MoviesEntity>> {
        val movieResults = MutableLiveData<ArrayList<MoviesEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
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
                movieResults.postValue(movieList)
            }
        })

        return movieResults
    }

    override fun getAllTvs(): MutableLiveData<ArrayList<TvEntity>>  {
        val tvResults = MutableLiveData<ArrayList<TvEntity>>()
        val tvList = ArrayList<TvEntity>()
        remoteDataSource.getAllTvs(object : RemoteDataSource.LoadTvsCallback {
            override fun onAllTvsReceived(tvResponse: List<TvResponse>) {
                val tvList = ArrayList<TvEntity>()
                for (response in tvResponse) {
                    val tv = TvEntity(
                        response.id,
                        response.name,
                        response.overview,
                        response.first_air_date,
                        response.poster_path,
                        response.backdrop_path,
                        response.vote_average
                    )
                    tvList.add(tv)
                }
                tvResults.postValue(tvList)
            }
        })

        return tvResults
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