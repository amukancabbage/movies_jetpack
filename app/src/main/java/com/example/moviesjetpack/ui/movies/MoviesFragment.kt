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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.moviesjetpack.R
import com.example.moviesjetpack.model.source.local.entity.MoviesEntity
import com.example.moviesjetpack.databinding.FragmentMoviesBinding
import com.example.moviesjetpack.utils.ViewModelFactory

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

        val binding: FragmentMoviesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies,container,false)
        val view: View = binding.root
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        progressBar?.visibility  = View.VISIBLE
        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
        viewModel.setNavigator(this)
        viewModel.getMovies()
        viewModel.getMoviesLiveData().observe(viewLifecycleOwner, Observer { moviesEntity ->
            binding.recyclerView.adapter = MoviesAdapter(moviesEntity, viewModel)
            progressBar?.visibility  = View.VISIBLE
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        progressBar = view.findViewById(R.id.progress_bar)
    }

}