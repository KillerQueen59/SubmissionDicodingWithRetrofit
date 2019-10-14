package com.example.submissiondicodingwithretrofit.api;

import com.example.submissiondicodingwithretrofit.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Connect {

    @GET("movie/popular")
    Call<MovieResponse> getPopularMovie (@Query("api_key")String api_key);
    @GET("tv/popular")
    Call<MovieResponse> getPopularTv (@Query("api_key")String api_key);
}
