package com.example.vaibhav.quotesapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.vaibhav.quotesapp.Interface.RequestInterface;
import com.example.vaibhav.quotesapp.Model.JSONResponse;
import com.example.vaibhav.quotesapp.Model.quote;
import com.example.vaibhav.quotesapp.Adapter.DataAdapter;

import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<quote> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON() {
        //https://api.learn2crack.com/android/jsonandroid/
        //https://api.myjson.com/bins/1fmyyf
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(@NonNull Call<JSONResponse> call, @NonNull Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
//                Log.d("myTAG", String.valueOf(jsonResponse.getQuotes()));
                if (jsonResponse != null) {
                    data = new ArrayList<>(jsonResponse.getQuotes());
                }
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(@NonNull Call<JSONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
