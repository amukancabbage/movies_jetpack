package com.example.moviesjetpack.ui.movies

import android.app.Activity
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesjetpack.R
import com.example.moviesjetpack.model.TvEntity


class TvAdapter() : RecyclerView.Adapter<TvAdapter.TvViewHolder>(), Parcelable {
    private var activity : Activity?=null
    private var mTv = ArrayList<TvEntity>()

    constructor(parcel: Parcel) : this() {

    }

    constructor(activity: Activity):this(){
        this.activity = activity

    }

    fun getListTv(): List<TvEntity>{
        return mTv
    }

    fun setListTv(listTv: ArrayList<TvEntity>){
        mTv.clear()
        mTv.addAll(listTv)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_movies, parent, false)
        return TvViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {

        holder.tvTitle.setText(getListTv().get(position).name)
        holder.tvDate.setText(getListTv().get(position).first_air_date)
        holder.tvDescription.setText(getListTv().get(position).overview)
        holder.itemView.setOnClickListener { v ->
            //            val intent = Intent(activity, DetailCourseActivity::class.java)
//            intent.putExtra(
//                DetailCourseActivity.EXTRA_COURSE,
//                listTv.get(position).getCourseId()
//            )
//            activity.startActivity(intent)
        }


        Glide.with(holder.itemView.context)
            .load(getListTv().get(position).poster_path)
//            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(holder.imgPoster)
    }

    override fun getItemCount(): Int {
        return getListTv().size
    }

    inner class TvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var tvDescription: TextView
        var tvDate: TextView
        var imgPoster: ImageView

        init {
            tvTitle = itemView.findViewById(R.id.tv_item_title)
            imgPoster = itemView.findViewById(R.id.img_poster)
            tvDescription = itemView.findViewById(R.id.tv_item_description)
            tvDate = itemView.findViewById(R.id.tv_item_date)
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