package com.example.vaibhav.quotesapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SingleViewActivity extends AppCompatActivity {
    private String quote, image;
    private TextView singleQuoteText;
    private ImageView singleQuoteImage;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);
        bindViews();
        quote = getIntent().getExtras().getString("text");
        image = getIntent().getExtras().getString("img");
        singleQuoteText.setText(quote);
        Picasso.with(SingleViewActivity.this).load(image).into(singleQuoteImage);
//        Log.d("dddddd", "" + quote + image);
    }

    private void bindViews() {
        singleQuoteImage = (ImageView) findViewById(R.id.single_image);
        singleQuoteText = (TextView) findViewById(R.id.single_text);

    }
}