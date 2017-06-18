package com.example.vaibhav.quotesapp.Interface;

/**
 * Created by vaibhav on 1/6/17.
 */


import com.example.vaibhav.quotesapp.Model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {
    @GET("/bins/1fmyyf")
    Call<JSONResponse> getJSON();
}