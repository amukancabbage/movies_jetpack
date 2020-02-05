package com.example.moviesjetpack.model.source.local.entity

import com.google.gson.annotations.SerializedName



class TvEntityResponse {
    @SerializedName("results")
    private val results: ArrayList<TvEntity>? = null

    fun getResults() : ArrayList<TvEntity>?{
        return results
    }

}