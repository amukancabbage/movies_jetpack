package com.example.moviesjetpack.ui.movies


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.moviesjetpack.R
import com.example.moviesjetpack.model.TvEntity
import kotlinx.android.synthetic.main.fragment_movies.*

class TvFragment : Fragment() {
    private var rvCourse: RecyclerView? = null
    private var progressBar: ProgressBar? = null
    private lateinit var moviesAdapter: TvAdapter
    private lateinit var viewModel: TvViewModel
    private var movies: List<TvEntity>? = null

    companion object {
        fun newInstance(): Fragment {
            val m = TvFragment()
            return m
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        progressBar = view.findViewById(R.id.progress_bar)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {


            viewModel = ViewModelProviders.of(this).get(TvViewModel::class.java)

            moviesAdapter = TvAdapter(requireActivity())
            moviesAdapter.notifyDataSetChanged()

            recyclerView.layoutManager = LinearLayoutManager(this.activity)
            recyclerView.adapter = moviesAdapter

            viewModel.setTvLiveData()


            viewModel.getTvLiveData().observe(this, Observer { moviesEntity ->
                if (moviesEntity != null) {
                    moviesAdapter.setListTv(moviesEntity)
//                    showLoading(false)
                }
            })



        }
    }

}
