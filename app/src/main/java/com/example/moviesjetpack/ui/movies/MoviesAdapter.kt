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
import com.bumptech.glide.request.RequestOptions
import com.example.moviesjetpack.R
import com.example.moviesjetpack.data.MoviesEntity
import com.example.moviesjetpack.utils.GlideApp


class MoviesAdapter() : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(), Parcelable {
    private var activity : Activity?=null
    private var mMovies = ArrayList<MoviesEntity>()

    constructor(parcel: Parcel) : this() {

    }

    constructor(activity: Activity):this(){
        this.activity = activity

    }

    fun getListMovies(): List<MoviesEntity>{
        return mMovies
    }

    fun setListMovies(listMovies: ArrayList<MoviesEntity>){
        mMovies.clear()
        mMovies.addAll(listMovies)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_movies, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.tvTitle.setText(getListMovies().get(position).title)
        holder.tvDescription.setText(getListMovies().get(position).overview)
        holder.itemView.setOnClickListener { v ->
//            val intent = Intent(activity, DetailCourseActivity::class.java)
//            intent.putExtra(
//                DetailCourseActivity.EXTRA_COURSE,
//                listMovies.get(position).getCourseId()
//            )
//            activity.startActivity(intent)
        }

        GlideApp.with(holder.itemView.context)
            .load(getListMovies().get(position).poster_path)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(holder.imgPoster)
    }

    override fun getItemCount(): Int {
        return getListMovies().size
    }

    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

    companion object CREATOR : Parcelable.Creator<MoviesAdapter> {
        override fun createFromParcel(parcel: Parcel): MoviesAdapter {
            return MoviesAdapter(parcel)
        }

        override fun newArray(size: Int): Array<MoviesAdapter?> {
            return arrayOfNulls(size)
        }
    }
}