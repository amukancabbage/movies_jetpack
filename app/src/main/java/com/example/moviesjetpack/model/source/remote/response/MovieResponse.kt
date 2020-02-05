package com.example.moviesjetpack.model.source.remote.response

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class MovieResponse(
    var id: String?,
    var title: String?,
    var overview: String?,
    var release_date: String?,
    var poster_path: String?,
    var backdrop_path: String?,
    var vote_average: String?

) : Parcelable {
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

    companion object CREATOR : Parcelable.Creator<MovieResponse> {
        override fun createFromParcel(parcel: Parcel): MovieResponse {
            return MovieResponse(parcel)
        }

        override fun newArray(size: Int): Array<MovieResponse?> {
            return arrayOfNulls(size)
        }
    }
}