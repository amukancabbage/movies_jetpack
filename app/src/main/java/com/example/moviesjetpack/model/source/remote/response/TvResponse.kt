package com.example.moviesjetpack.model.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponse(
    var id: String?,
    var name: String?,
    var overview: String?,
    var first_air_date: String?,
    var poster_path: String?,
    var backdrop_path: String?,
    var vote_average: String?

) : Parcelable