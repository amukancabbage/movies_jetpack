package com.example.moviesjetpack.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {

    fun create(): RetrofitServices {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.themoviedb.org/3/")
            .build()
        return retrofit.create(RetrofitServices::class.java)
    }


}
