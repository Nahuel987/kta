package com.example.kta.api;

import com.example.kta.BreedListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {

    @GET("api/breeds/list")
    Call<BreedListResponse> getBreedList();

}
