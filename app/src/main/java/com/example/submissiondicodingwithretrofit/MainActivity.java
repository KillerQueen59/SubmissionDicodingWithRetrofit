package com.example.submissiondicodingwithretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.submissiondicodingwithretrofit.fragment.MovieFragment;
import com.example.submissiondicodingwithretrofit.fragment.TvFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private MovieFragment movieFragment;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieFragment = new MovieFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameMovie,movieFragment )
                .commit();
        bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;

                switch (menuItem.getItemId()){
                    case R.id.Movies:
                        fragment = new MovieFragment();
                        break;
                    case R.id.Tv:
                        fragment = new TvFragment();
                        break;
                }
                return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameMovie,fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
