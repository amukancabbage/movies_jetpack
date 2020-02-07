package com.example.moviesjetpack.model.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieResponse(
    var id: String?,
    var title: String?,
    var overview: String?,
    var release_date: String?,
    var poster_path: String?,
    var backdrop_path: String?,
    var vote_average: String?

) : Parcelable