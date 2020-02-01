package com.example.moviesjetpack.model

import com.google.gson.annotations.SerializedName



class TvEntityResponse {
    @SerializedName("results")
    private val results: ArrayList<TvEntity>? = null

    fun getResults() : ArrayList<TvEntity>?{
        return results
    }

}