package com.hcode.javalagdevelopers.api;

import com.hcode.javalagdevelopers.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hassan on 11/22/2017.
 */

public interface Service {
    @GET("/search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
}
