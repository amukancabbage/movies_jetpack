package com.example.moviesjetpack.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesjetpack.data.Repository
import com.example.moviesjetpack.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    private val listMovies = MutableLiveData<ArrayList<MoviesEntity>>()
    lateinit var moviesNavigator : MoviesNavigator

    fun setNavigator(moviesNavigator: MoviesNavigator){
        this.moviesNavigator = moviesNavigator
    }

    internal fun getMoviesLiveData(): LiveData<ArrayList<MoviesEntity>> {
        return listMovies
    }

    internal fun setMoviesLiveData() {

        val listItems= ArrayList<MoviesEntity>()
        val movieServices = Repository.create()

        movieServices.getPosts().enqueue(object : Callback<MoviesEntityResponse> {

            override fun onResponse(
                call: Call<MoviesEntityResponse>,
                response: Response<MoviesEntityResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.getResults()

                    data?.map {
                        val movieItems = MoviesEntity(
                            it.id,
                            it.title,
                            it.overview,
                            it.release_date,
                            "https://image.tmdb.org/t/p/w500" + it.poster_path,
                            "https://image.tmdb.org/t/p/w500" + it.backdrop_path,
                            it.vote_average
                        )
                        listItems.add(movieItems)
                    }

                    listMovies.postValue(listItems)

                }
            }

            override fun onFailure(call: Call<MoviesEntityResponse>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }
        })

    }

    fun itemClick(moviesEntity: MoviesEntity){
        moviesNavigator.onItemClick(moviesEntity)
    }
}

