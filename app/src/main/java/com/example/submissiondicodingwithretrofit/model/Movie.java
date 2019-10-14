package com.example.submissiondicodingwithretrofit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {

    @SerializedName("name")
    private String title_tv;
    @SerializedName("first_air_date")
    private String date_tv;
    @SerializedName("title")
    private String title;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("id")
    private int id;
    @SerializedName("vote_average")
    private float vote_average;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("adult")
    private boolean adult;

    public Movie(){
    }

    public Movie(String title_tv, String date_tv, String title, String poster_path, int id, float vote_average, String overview, String release_date, boolean adult) {
        this.title_tv = title_tv;
        this.date_tv = date_tv;
        this.title = title;
        this.poster_path = poster_path;
        this.id = id;
        this.vote_average = vote_average;
        this.overview = overview;
        this.release_date = release_date;
        this.adult = adult;
    }

    protected Movie(Parcel in) {
        title_tv = in.readString();
        date_tv = in.readString();
        title = in.readString();
        poster_path = in.readString();
        id = in.readInt();
        vote_average = in.readFloat();
        overview = in.readString();
        release_date = in.readString();
        adult = in.readByte() != 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle_tv() {
        return title_tv;
    }

    public void setTitle_tv(String title_tv) {
        this.title_tv = title_tv;
    }

    public String getDate_tv() {
        return date_tv;
    }

    public void setDate_tv(String date_tv) {
        this.date_tv = date_tv;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return "https://image.tmdb.org/t/p/original/" + poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title_tv);
        parcel.writeString(date_tv);
        parcel.writeString(title);
        parcel.writeString(poster_path);
        parcel.writeInt(id);
        parcel.writeFloat(vote_average);
        parcel.writeString(overview);
        parcel.writeString(release_date);
        parcel.writeByte((byte) (adult ? 1 : 0));
    }
}
