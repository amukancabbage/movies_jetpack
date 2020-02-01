package com.example.moviesjetpack.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TvEntity (
    @SerializedName("id")
    var id: String?,

    @SerializedName("name")
    var name: String?,

    @SerializedName("overview")
    var overview: String?,

    @SerializedName("first_air_date")
    var first_air_date: String?,

    @SerializedName("poster_path")
    var poster_path: String?,

    @SerializedName("backdrop_path")
    var backdrop_path: String?

): Parcelable {
    constructor(parcel: Parcel) : this(
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
    }
}