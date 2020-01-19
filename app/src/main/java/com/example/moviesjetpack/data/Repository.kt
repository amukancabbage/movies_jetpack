package com.example.moviesjetpack.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Repository {

    fun create(): MoviesServices {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/search/")
            .build()
        return retrofit.create(MoviesServices::class.java)
    }


}
