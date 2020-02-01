package com.example.moviesjetpack.model

import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import com.bumptech.glide.request.target.Target

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
    }


}