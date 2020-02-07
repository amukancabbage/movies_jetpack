package com.example.moviesjetpack.ui.movies

import android.nfc.NfcAdapter.EXTRA_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.example.moviesjetpack.R
import com.example.moviesjetpack.databinding.ActivityMoviesDetailBinding
import com.example.moviesjetpack.model.source.local.entity.MoviesEntity

class MoviesDetailActivity : AppCompatActivity() {

    lateinit var databinding : ActivityMoviesDetailBinding

    companion object{
       const val EXTRA_DATA = "extra_data"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR);
        actionBar?.hide()
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_movies_detail)
        val moviesEntity = intent.getParcelableExtra<MoviesEntity>(EXTRA_DATA)
        databinding.movieEntity = moviesEntity

    }
}
