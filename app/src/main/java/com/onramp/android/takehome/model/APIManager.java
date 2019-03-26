package com.onramp.android.takehome.model;

import android.util.Log;

import com.onramp.android.takehome.model.pets.PetObjects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {
    private static final String BASE_URL = "http://api.connectpetsto.me/";
    private ConnectPetsAPI api;

    public APIManager(){
        api = (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build())
                .create(ConnectPetsAPI.class);
    }

    public void getResults(String params){
        Call<PetObjects> call = api.getPets(params);
        call.enqueue(new Callback<PetObjects>() {
            @Override
            public void onResponse(Call<PetObjects> call, Response<PetObjects> response) {
                Log.d("test", "response: " + response.body().getObjects().get(0).getName());
            }

            @Override
            public void onFailure(Call<PetObjects> call, Throwable t) {

            }
        });
    }
}
