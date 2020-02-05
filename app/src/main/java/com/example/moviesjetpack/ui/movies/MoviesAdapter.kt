package com.example.moviesjetpack.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesjetpack.R
import com.example.moviesjetpack.model.source.local.entity.MoviesEntity
import com.example.moviesjetpack.databinding.ItemsMoviesBinding


class MoviesAdapter() : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var mMovies = ArrayList<MoviesEntity>()
    private lateinit var viewModel: MoviesViewModel

    constructor(mMovies: ArrayList<MoviesEntity>, viewModel: MoviesViewModel):this(){
        this.mMovies = mMovies
        this.viewModel = viewModel

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemsMoviesBinding = DataBindingUtil.inflate(layoutInflater,R.layout.items_movies,parent,false)
        return MoviesViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {

        val moviesEntity: MoviesEntity =mMovies.get(position)
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

}