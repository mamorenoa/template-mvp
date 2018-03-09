package com.template.data.api.services;

import com.template.data.api.response.ServerFilm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIService {

    //https://api.myjson.com/bins/1b5yg9
    //Endpoint
    String API = "https://api.myjson.com";

    //Headers
    String CONTENT_TYPE = "Content-Type: application/json";
    String ACCEPT = "Accept: application/json";

    @Headers({CONTENT_TYPE, ACCEPT})
    @GET("bins/1b5yg9")
    Call<List<ServerFilm>> getFilms();
}