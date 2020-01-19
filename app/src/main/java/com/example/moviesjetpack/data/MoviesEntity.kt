package com.example.moviesjetpack.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

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
    var poster_path: String?

): Parcelable {
    constructor(parcel: Parcel) : this(
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