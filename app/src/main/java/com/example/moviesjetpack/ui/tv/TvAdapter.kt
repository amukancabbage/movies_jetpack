package com.example.moviesjetpack.ui.tv

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesjetpack.R
import com.example.moviesjetpack.databinding.ItemsTvBinding
import com.example.moviesjetpack.model.source.local.entity.TvEntity


class TvAdapter() : RecyclerView.Adapter<TvAdapter.TvViewHolder>(), Parcelable {
    private var mTv = ArrayList<TvEntity>()
    private lateinit var viewModel: TvViewModel

    constructor(parcel: Parcel) : this() {

    }


    constructor(mTv: ArrayList<TvEntity>, viewModel: TvViewModel):this(){
        this.mTv = mTv
        this.viewModel = viewModel

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var binding : ItemsTvBinding = DataBindingUtil.inflate(layoutInflater,R.layout.items_tv,parent,false)
        return TvViewHolder(binding)

    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {

        var tvEntity: TvEntity =mTv.get(position)
        holder.setBinding(tvEntity, viewModel)
    }

    override fun getItemCount(): Int {
        return mTv.size
    }


    inner class TvViewHolder constructor(val binding: ItemsTvBinding) : RecyclerView.ViewHolder(binding.root){

        fun setBinding(tvEntity: TvEntity, tvViewModel: TvViewModel){
            binding.tvEntity = tvEntity
            binding.tvViewModel= tvViewModel
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvAdapter> {
        override fun createFromParcel(parcel: Parcel): TvAdapter {
            return TvAdapter(parcel)
        }

        override fun newArray(size: Int): Array<TvAdapter?> {
            return arrayOfNulls(size)
        }
    }
}