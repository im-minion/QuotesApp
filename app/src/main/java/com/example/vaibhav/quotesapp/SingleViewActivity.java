package com.example.vaibhav.quotesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SingleViewActivity extends AppCompatActivity {
    String quote, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);
        quote = getIntent().getExtras().getString("text");
        image = getIntent().getExtras().getString("img");
        Log.d("dddddd", "" + quote + image);
    }
}
