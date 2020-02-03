package com.example.moviesjetpack.ui.movies


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.moviesjetpack.R
import com.example.moviesjetpack.model.MoviesEntity
import com.example.moviesjetpack.databinding.FragmentMoviesBinding
import kotlinx.android.synthetic.main.fragment_movies.*

class MoviesFragment : Fragment(),MoviesNavigator {

    private var progressBar: ProgressBar? = null
    private lateinit var viewModel: MoviesViewModel

    companion object {
        fun newInstance(): Fragment {
            val m = MoviesFragment()
            return m
        }
    }

    override fun onItemClick(moviesEntity: MoviesEntity) {
        val intent = Intent(activity, MoviesDetailActivity::class.java)
        intent.putExtra(MoviesDetailActivity.EXTRA_DATA,moviesEntity)
        activity?.startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentMoviesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies,container,false)
        var view: View = binding.root
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        viewModel.setNavigator(this)
//        viewModel.setMoviesLiveData()
        viewModel.setMoviesDummy()
        viewModel.getMoviesLiveData().observe(this, Observer { moviesEntity ->
            binding.recyclerView.adapter = MoviesAdapter(moviesEntity, viewModel)
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        progressBar = view.findViewById(R.id.progress_bar)
    }

}