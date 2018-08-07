package com.example.surainrsinnasamy.makingminiproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("pokemon/12")
    Call<PokemonModelClass> getPokemonProfiles();

    @GET("pokemon/{id}")
    Call<PokemonModelClass> getPokemonProfilesList(@Path("id") int pokemonId);
}



