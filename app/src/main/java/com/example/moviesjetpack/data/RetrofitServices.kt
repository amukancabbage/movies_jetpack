package com.example.moviesjetpack.data

import com.example.moviesjetpack.model.source.local.entity.MoviesEntityResponse
import com.example.moviesjetpack.model.source.local.entity.TvEntityResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {


    @GET("movie/now_playing?api_key=794813bc026f6d6aa4f7e8bf2317313e&language=en-US&page=1")
    fun getPosts(): Call<MoviesEntityResponse>

    @GET("tv/airing_today?api_key=794813bc026f6d6aa4f7e8bf2317313e&language=en-US&page=1")
    fun getPostsTv(): Call<TvEntityResponse>
}