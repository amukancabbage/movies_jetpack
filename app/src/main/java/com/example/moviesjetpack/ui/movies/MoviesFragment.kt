package com.example.moviesjetpack.ui.movies


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView

import com.example.moviesjetpack.R
import com.example.moviesjetpack.data.MoviesEntity

class MoviesFragment : Fragment() {
    private var rvCourse: RecyclerView? = null
    private var progressBar: ProgressBar? = null
    private var moviesAdapter: MoviesAdapter? = null
    private var viewModel: MoviesViewModel? = null
    private var movies: List<MoviesEntity>? = null


    companion object {
        fun newInstance(): Fragment {
            return MoviesFragment()
        }
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCourse = view.findViewById(R.id.rv_academy)
        progressBar = view.findViewById(R.id.progress_bar)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
            movies = viewModel!!.getMovies()


            moviesAdapter = MoviesAdapter()
            moviesAdapter!!.setListMovies(viewModel!!.getMovies())
            rvCourse!!.setHasFixedSize(true)
            rvCourse!!.adapter = moviesAdapter
        }
    }


}