package com.example.submissiondicodingwithretrofit.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.submissiondicodingwithretrofit.BuildConfig;
import com.example.submissiondicodingwithretrofit.R;
import com.example.submissiondicodingwithretrofit.adapter.MovieAdapter;
import com.example.submissiondicodingwithretrofit.api.Client;
import com.example.submissiondicodingwithretrofit.api.Connect;
import com.example.submissiondicodingwithretrofit.model.Movie;
import com.example.submissiondicodingwithretrofit.model.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView recyclerView;
    private View view;
    private MovieAdapter adapter;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = view.findViewById(R.id.recycleView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);

        Client client = new Client();
        Connect connect = Client.getClient().create(Connect.class);
        Call<MovieResponse> call = connect.getPopularMovie(BuildConfig.MovieDbApi);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()){
                    Log.d("succes222", String.valueOf(response.body()));
                    if (response.body()==null){
                        Log.d("error222", "error");
                    }else {
                        List<Movie> movies = response.body().getMovies();
                        Log.d("succes222", String.valueOf(response.body().getMovies()));
                        recyclerView.setAdapter(new MovieAdapter(movies,getActivity()));
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("master", "onFailure: "+t.toString());
            }
        });

        return view;
    }

}
