package com.example.moviesjetpack.ui.tv


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
import com.example.moviesjetpack.model.source.local.entity.TvEntity
import com.example.moviesjetpack.databinding.FragmentTvBinding
import com.example.moviesjetpack.ui.movies.MoviesAdapter
import com.example.moviesjetpack.ui.movies.MoviesViewModel
import com.example.moviesjetpack.utils.ViewModelFactory

class TvFragment : Fragment(), TvNavigator {

    private var progressBar: ProgressBar? = null
    private lateinit var viewModel: TvViewModel

    companion object {
        fun newInstance(): Fragment {
            val m = TvFragment()
            return m
        }
    }

    override fun onItemClick(tvEntity: TvEntity) {
        val intentTv = Intent(activity, TvDetailActivity::class.java)
        intentTv.putExtra(TvDetailActivity.EXTRA_DATA_TV,tvEntity)
        activity?.startActivity(intentTv)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentTvBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_tv,container,false)
        val view: View = binding.root
        binding.recyclerViewTv.layoutManager = LinearLayoutManager(activity)

        progressBar?.visibility  = View.VISIBLE
        val factory = ViewModelFactory.getInstance(requireActivity())
        viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
        viewModel.setNavigator(this)
        viewModel.getTvs()
        viewModel.getTvLiveData().observe(viewLifecycleOwner, Observer { tvEntity ->
            binding.recyclerViewTv.adapter = TvAdapter(tvEntity, viewModel)
            progressBar?.visibility  = View.VISIBLE
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        progressBar = view.findViewById(R.id.progress_bar)
    }

}