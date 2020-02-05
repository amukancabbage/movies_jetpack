package com.example.moviesjetpack.ui.tv

import com.example.moviesjetpack.model.source.local.entity.TvEntity

interface TvNavigator {
    fun onItemClick(tvEntity: TvEntity)

}