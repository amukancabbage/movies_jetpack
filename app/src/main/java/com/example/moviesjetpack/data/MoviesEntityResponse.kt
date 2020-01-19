package com.example.moviesjetpack.data

import java.util.HashMap
import com.google.gson.annotations.SerializedName



class MoviesEntityResponse {
    @SerializedName("results")
    private val results: ArrayList<MoviesEntity>? = null

    fun getResults() : ArrayList<MoviesEntity>?{
        return results
    }

}