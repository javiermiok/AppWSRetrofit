package com.example.a21752434.appwsretrofit.retrofitUtils;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRestService {

    public static final String BASE_URL = "https://pokeapi.co/api/v2/";

    @GET("pokemon/")
    Call<String> obtenerPokemons();

}
