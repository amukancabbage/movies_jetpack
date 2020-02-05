package com.example.moviesjetpack.model.source.remote.response

import android.os.Parcel
import android.os.Parcelable


data class TvResponse(
    var id: String?,
    var name: String?,
    var overview: String?,
    var first_air_date: String?,
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
        parcel.writeString(name)
        parcel.writeString(overview)
        parcel.writeString(first_air_date)
        parcel.writeString(poster_path)
        parcel.writeString(backdrop_path)
        parcel.writeString(vote_average)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvResponse> {
        override fun createFromParcel(parcel: Parcel): TvResponse {
            return TvResponse(parcel)
        }

        override fun newArray(size: Int): Array<TvResponse?> {
            return arrayOfNulls(size)
        }
    }
}