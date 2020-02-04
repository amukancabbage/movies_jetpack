package com.example.moviesjetpack.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesjetpack.model.TvEntity
import com.example.moviesjetpack.utils.DataDummy

class TvViewModel : ViewModel() {

    val listTv = MutableLiveData<ArrayList<TvEntity>>()
    lateinit var tvNavigator : TvNavigator

    fun setNavigator(tvNavigator: TvNavigator){
        this.tvNavigator = tvNavigator
    }

    internal fun getTvLiveData(): LiveData<ArrayList<TvEntity>> {
        return listTv
    }


    internal fun setTvDummy() {
        val listItems= DataDummy.generateDummyTvs()
        listTv.postValue(listItems)
    }

    fun itemClick(tvEntity: TvEntity) {
        tvNavigator.onItemClick(tvEntity)
    }
}

