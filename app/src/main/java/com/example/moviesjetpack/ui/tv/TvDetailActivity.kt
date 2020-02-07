package com.example.moviesjetpack.ui.tv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.example.moviesjetpack.R
import com.example.moviesjetpack.databinding.ActivityTvDetailBinding
import com.example.moviesjetpack.model.source.local.entity.TvEntity

class TvDetailActivity : AppCompatActivity() {

    lateinit var databinding : ActivityTvDetailBinding

    companion object{
        const val EXTRA_DATA_TV = "extra_data_tv"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        actionBar?.hide()
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_tv_detail)
        val tvEntity = intent.getParcelableExtra<TvEntity>(EXTRA_DATA_TV)
        databinding.tvEntity = tvEntity

    }
}
