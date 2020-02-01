package com.example.moviesjetpack.ui.movies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesjetpack.data.MoviesEntity
import com.example.moviesjetpack.data.MoviesEntityResponse
import com.example.moviesjetpack.data.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    companion object {
        private const val API_KEY = "794813bc026f6d6aa4f7e8bf2317313e"
    }

    private val listMovies = MutableLiveData<ArrayList<MoviesEntity>>()


    internal fun getMoviesLiveData(): LiveData<ArrayList<MoviesEntity>> {
        return listMovies
    }

    internal fun setMoviesLiveData(isMovies: Boolean) {

        val listItems= ArrayList<MoviesEntity>()

        val movieServices = Repository.create()

        if(isMovies){
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
                                "https://image.tmdb.org/t/p/w500" + it.poster_path
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
        }else{
            movieServices.getPostsTv().enqueue(object : Callback<MoviesEntityResponse> {

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
                                "https://image.tmdb.org/t/p/w500" + it.poster_path
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

    }
}

