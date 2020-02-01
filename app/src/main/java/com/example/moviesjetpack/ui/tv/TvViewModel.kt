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

class TvViewModel : ViewModel() {

    companion object {
        private const val API_KEY = "794813bc026f6d6aa4f7e8bf2317313e"
    }

    private val listTv = MutableLiveData<ArrayList<TvEntity>>()


    internal fun getTvLiveData(): LiveData<ArrayList<TvEntity>> {
        return listTv
    }


    internal fun setTvLiveData() {

        val listItems= ArrayList<TvEntity>()
        val movieServices = Repository.create()

        movieServices.getPostsTv().enqueue(object : Callback<TvEntityResponse> {

            override fun onResponse(
                call: Call<TvEntityResponse>,
                response: Response<TvEntityResponse>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.getResults()

                    data?.map {
                        val movieItems = TvEntity(
                            it.id,
                            it.name,
                            it.overview,
                            it.first_air_date,
                            "https://image.tmdb.org/t/p/w500" + it.poster_path,
                            "https://image.tmdb.org/t/p/w500" + it.backdrop_path
                        )
                        listItems.add(movieItems)
                    }

                    listTv.postValue(listItems)

                }
            }

            override fun onFailure(call: Call<TvEntityResponse>, error: Throwable) {
                Log.e("tag", "errornya ${error.message}")
            }
        })

    }
}

