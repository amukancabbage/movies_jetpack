package com.example.moviesjetpack.di

import android.content.Context
import com.example.moviesjetpack.model.source.MovieRepository
import com.example.moviesjetpack.model.source.remote.RemoteDataSource
import com.example.moviesjetpack.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieRepository.getInstance(remoteDataSource)
    }
}