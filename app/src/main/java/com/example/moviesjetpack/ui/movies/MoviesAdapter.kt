package com.example.moviesjetpack.ui.movies

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesjetpack.R
import com.example.moviesjetpack.model.source.local.entity.MoviesEntity
import com.example.moviesjetpack.databinding.ItemsMoviesBinding


class MoviesAdapter() : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(), Parcelable {
    private var mMovies = ArrayList<MoviesEntity>()
    private lateinit var viewModel: MoviesViewModel

    constructor(parcel: Parcel) : this() {

    }


    constructor(mMovies: ArrayList<MoviesEntity>, viewModel: MoviesViewModel):this(){
        this.mMovies = mMovies
        this.viewModel = viewModel

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var binding : ItemsMoviesBinding = DataBindingUtil.inflate(layoutInflater,R.layout.items_movies,parent,false)
        return MoviesViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        var moviesEntity: MoviesEntity =mMovies.get(position)
        holder.setBinding(moviesEntity, viewModel)
    }

    override fun getItemCount(): Int {
        return mMovies.size
    }


    inner class MoviesViewHolder constructor(val binding: ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root){

        fun setBinding(moviesEntity: MoviesEntity, moviesViewModel: MoviesViewModel){
            binding.movieEntity = moviesEntity
            binding.viewModel = moviesViewModel
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoviesAdapter> {
        override fun createFromParcel(parcel: Parcel): MoviesAdapter {
            return MoviesAdapter(parcel)
        }

        override fun newArray(size: Int): Array<MoviesAdapter?> {
            return arrayOfNulls(size)
        }
    }
}