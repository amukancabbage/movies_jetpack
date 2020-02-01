package com.example.moviesjetpack.ui.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviesjetpack.R
import com.example.moviesjetpack.databinding.ActivityMoviesDetailBinding
import com.example.moviesjetpack.model.MoviesEntity

class MoviesDetailActivity : AppCompatActivity() {

    lateinit var databinding : ActivityMoviesDetailBinding

    companion object{
       val EXTRA_DATA = "extra_data"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_movies_detail)
        var moviesEntity = intent.getParcelableExtra<MoviesEntity>(EXTRA_DATA)
        databinding.movieEntity = moviesEntity

    }
}
