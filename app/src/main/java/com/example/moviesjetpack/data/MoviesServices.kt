package com.example.moviesjetpack.data

import retrofit2.Call
import retrofit2.http.GET

interface MoviesServices {
    @GET("movie?api_key=794813bc026f6d6aa4f7e8bf2317313e&language=en-US&query=Superman")
    fun getPosts(): Call<MoviesEntityResponse>
}