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
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.moviesjetpack.R
import com.example.moviesjetpack.model.TvEntity
import com.example.moviesjetpack.databinding.FragmentTvBinding

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

        var binding: FragmentTvBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_tv,container,false)
        var view: View = binding.root
        binding.recyclerViewTv.layoutManager = LinearLayoutManager(activity)
        viewModel = ViewModelProviders.of(this).get(TvViewModel::class.java)
        viewModel.setNavigator(this)
//        viewModel.setTvLiveData()
        viewModel.setTvDummy()
        viewModel.getTvLiveData().observe(this, Observer { tvEntity ->
            binding.recyclerViewTv.adapter = TvAdapter(tvEntity, viewModel)
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        progressBar = view.findViewById(R.id.progress_bar)
    }

}