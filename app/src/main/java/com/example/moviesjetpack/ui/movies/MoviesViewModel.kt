package com.example.moviesjetpack.ui.movies

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.moviesjetpack.data.MoviesEntity
import com.example.moviesjetpack.data.MoviesEntityResponse
import com.example.moviesjetpack.data.Repository
import com.example.moviesjetpack.utils.Data
import com.example.moviesjetpack.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {
    fun getMovies(): ArrayList<MoviesEntity> {
        return Data.generateMovies()
    }
}

