package com.example.moviesjetpack.model.source.remote

import android.os.Handler
import com.example.moviesjetpack.model.source.remote.response.MovieResponse
import com.example.moviesjetpack.model.source.remote.response.TvResponse
import com.example.moviesjetpack.utils.EspressoIdlingResource
import com.example.moviesjetpack.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    //untuk delay
    private val handler = Handler()

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getAllMovies():ArrayList<MovieResponse> = jsonHelper.loadMovies()
    fun getAllTvs():ArrayList<TvResponse> = jsonHelper.loadTvs()
    fun getAllMovies(callback: LoadMoviesCallback){
        EspressoIdlingResource.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        },
            SERVICE_LATENCY_IN_MILLIS
        )
    }
    fun getAllTvs(callback: LoadTvsCallback){
        EspressoIdlingResource.increment()

        handler.postDelayed({
            callback.onAllTvsReceived(jsonHelper.loadTvs())
            EspressoIdlingResource.decrement()
        },
            SERVICE_LATENCY_IN_MILLIS
        )
    }




    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadTvsCallback {
        fun onAllTvsReceived(tvResponses: List<TvResponse>)
    }

}