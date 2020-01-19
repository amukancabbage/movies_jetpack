package com.example.moviesjetpack.data

import java.util.HashMap
import com.google.gson.annotations.SerializedName



class MoviesEntityResponse {
    @SerializedName("results")
    private val results: List<MoviesEntity>? = null

    fun getResults() : List<MoviesEntity>?{
        return results
    }

}