package com.example.moviesjetpack.utils

import android.content.Context
import com.example.moviesjetpack.model.source.remote.response.MovieResponse
import com.example.moviesjetpack.model.source.remote.response.TvResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MoviesResponse.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)

                val id = course.getString("id")
                val title = course.getString("title")
                val overview = course.getString("overview")
                val releaseDate = course.getString("release_date")
                val posterPath = "https://image.tmdb.org/t/p/w500"+course.getString("poster_path")
                val backdropPath = "https://image.tmdb.org/t/p/w500"+course.getString("backdrop_path")
                val voteAverage = course.getString("vote_average")

                val courseResponse = MovieResponse(id, title, overview, releaseDate, posterPath, backdropPath, voteAverage)
                list.add(courseResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvs(): List<TvResponse> {
        val list = ArrayList<TvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvResponse.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val course = listArray.getJSONObject(i)

                val id = course.getString("id")
                val name = course.getString("name")
                val overview = course.getString("overview")
                val firstAirDate = course.getString("first_air_date")
                val posterPath = "https://image.tmdb.org/t/p/w500"+course.getString("poster_path")
                val backdropPath = "https://image.tmdb.org/t/p/w500"+course.getString("backdrop_path")
                val voteAverage = course.getString("vote_average")

                val courseResponse = TvResponse(id, name, overview, firstAirDate, posterPath, backdropPath, voteAverage)
                list.add(courseResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}