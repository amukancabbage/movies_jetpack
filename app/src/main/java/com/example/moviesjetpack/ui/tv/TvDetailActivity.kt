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
        val EXTRA_DATA_TV = "extra_data_tv"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        actionBar?.hide()
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_tv_detail)
        var tvEntity = intent.getParcelableExtra<TvEntity>(EXTRA_DATA_TV)

        var tv = TvEntity(
            "71663",
            "Black Lightning",
            "Jefferson Pierce is a man wrestling with a secret. As the father of two daughters and principal of a charter high school that also serves as a safe haven for young people in a New Orleans neighborhood overrun by gang violence, he is a hero to his community.",
            "2018-01-16",
            "https://image.tmdb.org/t/p/w500/90QFKG1QK7szgMIB2SxFADY1pvy.jpg",
            "https://image.tmdb.org/t/p/w500/h6QhUjIquntBfvD8nm71RoEgwvr.jpg", "6.7"
        )
        databinding.tvEntity = tvEntity

    }
}
