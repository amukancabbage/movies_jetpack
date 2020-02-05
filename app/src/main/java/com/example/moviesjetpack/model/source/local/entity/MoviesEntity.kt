package com.example.moviesjetpack.model.source.local.entity

import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import android.widget.RatingBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.google.gson.annotations.SerializedName
import com.bumptech.glide.request.target.Target
import com.example.moviesjetpack.R
import java.lang.Float

data class MoviesEntity (
    @SerializedName("id")
    var id: String?,

    @SerializedName("title")
    var title: String?,

    @SerializedName("overview")
    var overview: String?,

    @SerializedName("release_date")
    var release_date: String?,

    @SerializedName("poster_path")
    var poster_path: String?,

    @SerializedName("backdrop_path")
    var backdrop_path: String?,

    @SerializedName("vote_average")
    var vote_average: String?

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(overview)
        parcel.writeString(release_date)
        parcel.writeString(poster_path)
        parcel.writeString(backdrop_path)
        parcel.writeString(vote_average)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MoviesEntity> {
        override fun createFromParcel(parcel: Parcel): MoviesEntity {
            return MoviesEntity(parcel)
        }

        override fun newArray(size: Int): Array<MoviesEntity?> {
            return arrayOfNulls(size)
        }

        @JvmStatic
        @BindingAdapter(value = ["poster_path", "error"], requireAll = false)
        fun loadImage(view: ImageView, poster_path: String, error: Int) {
            Glide.with(view.context)
                .load(poster_path)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        view.setImageResource(error)
                        return true
                    }
                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        view.setImageDrawable(resource)
                        return true
                    }
                })
                .into(view)
        }

        @JvmStatic
        @BindingAdapter("vote_average")
        fun setRating(rating_bar: RatingBar, vote_average: String?){
            if (vote_average != null) {
                var float_vote_average = Float.parseFloat(vote_average)
                float_vote_average = float_vote_average/2
                rating_bar.rating = float_vote_average
                val stars = rating_bar.progressDrawable as LayerDrawable
                stars.getDrawable(2).setColorFilter(ContextCompat.getColor(rating_bar.context, R.color.colorAccent), PorterDuff.Mode.SRC_ATOP)
                val roundVal = Math.round(float_vote_average!!)
                rating_bar.numStars = 5
            }

        }
    }


}