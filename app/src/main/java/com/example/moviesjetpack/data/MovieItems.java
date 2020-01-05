package com.example.moviesjetpack.data;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MovieItems  {
//    private int id;
//    private String title;
//    private String overview;
//    private String release_date;
//    private String poster_path;
//
//    public MovieItems(JSONObject object) {
//
//        try {
//            int id = object.getInt("id");
//            String title = object.getString("title");
//            String overview = object.getString("overview");
//            String release_date = object.getString("release_date");
//            String poster_path = object.getString("poster_path");
//
//            this.id = id;
//            this.title = title;
//            this.overview = overview;
//            this.release_date= release_date;
//            this.poster_path = "http://image.tmdb.org/t/p/w92"+poster_path;
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public MovieItems(){}
//
//    public MovieItems(int id, String title, String overview, String release_date, String poster_path) {
//        this.id = id;
//        this.title = title;
//        this.overview = overview;
//        this.release_date = release_date;
//        this.poster_path = poster_path;
//    }
//
////    public MovieItems(Cursor cursor){
////        this.id = DatabaseContract.getColumnInt(cursor, DatabaseContract.FavColumns.ID);
////        this.title = DatabaseContract.getColumnString(cursor, DatabaseContract.FavColumns.TITLE);
////        this.overview = DatabaseContract.getColumnString(cursor, DatabaseContract.FavColumns.OVERVIEW);
////        this.release_date = DatabaseContract.getColumnString(cursor, DatabaseContract.FavColumns.RELEASE_DATE);
////        this.poster_path = DatabaseContract.getColumnString(cursor, DatabaseContract.FavColumns.POSTER_PATH);
////    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getOverview() {
//        return overview;
//    }
//
//    public void setOverview(String overview) {
//        this.overview = overview;
//    }
//
//    public String getRelease_date() {
//        return release_date;
//    }
//
//    public void setRelease_date(String release_date) {
//        this.release_date = release_date;
//    }
//
//    public String getPoster_path() {
//        return poster_path;
//    }
//
//    public void setPoster_path(String poster_path) {
//        this.poster_path = poster_path;
//    }
//
//    public String formattedDate(String releaseDate){
//        String fd="";
//        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date date = date_format.parse(releaseDate);
//            SimpleDateFormat new_date_format = new SimpleDateFormat("EEEE, MMM d, yyyy");
//            fd = new_date_format.format(date);
//
//        } catch (Exception e) {
//
//        }
//        return fd;
//    }
//
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(this.id);
//        dest.writeString(this.title);
//        dest.writeString(this.overview);
//        dest.writeString(this.release_date);
//        dest.writeString(this.poster_path);
//    }
//
//    protected MovieItems(Parcel in) {
//        this.id = in.readInt();
//        this.title = in.readString();
//        this.overview = in.readString();
//        this.release_date = in.readString();
//        this.poster_path = in.readString();
//    }
//
//    public static final Parcelable.Creator<MovieItems> CREATOR = new Parcelable.Creator<MovieItems>() {
//        @Override
//        public MovieItems createFromParcel(Parcel source) {
//            return new MovieItems(source);
//        }
//
//        @Override
//        public MovieItems[] newArray(int size) {
//            return new MovieItems[size];
//        }
//    };


}