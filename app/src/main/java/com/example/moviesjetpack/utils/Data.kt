package com.example.moviesjetpack.utils

import android.util.Log
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesjetpack.R
import com.example.moviesjetpack.data.MoviesEntity
import com.example.moviesjetpack.data.MoviesEntityResponse
import com.example.moviesjetpack.data.Repository
import com.example.moviesjetpack.ui.movies.MoviesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Data {


    companion object {
        fun generateMovies(): ArrayList<MoviesEntity> {

            var rvCourse: RecyclerView? = null
            var moviesAdapter: MoviesAdapter? = null


            var movies = ArrayList<MoviesEntity>()


            val movieServices = Repository.create()
            movieServices.getPosts().enqueue(object : Callback<MoviesEntityResponse> {

                    override fun onResponse(
                        call: Call<MoviesEntityResponse>,
                        response: Response<MoviesEntityResponse>) {
                        if (response.isSuccessful) {
                            val data = response.body()?.getResults()
                            Log.d("tag", "responsenya ${data?.size}")

                            data?.map {
                                Log.d("tag", "datanya ini: ${it.title}")
                            }

                            movies = response.body()?.getResults()!!

                            moviesAdapter = MoviesAdapter()
                            moviesAdapter!!.setListMovies(data)
                            rvCourse!!.setHasFixedSize(true)
                            rvCourse!!.adapter = moviesAdapter
                        }
                    }

                    override fun onFailure(call: Call<MoviesEntityResponse>, error: Throwable) {
                        Log.e("tag", "errornya ${error.message}")
                    }
                }
            )
            return movies
        }
    }
}