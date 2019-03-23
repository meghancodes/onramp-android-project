package com.onramp.android.takehome.model;

import android.util.Log;

import com.onramp.android.takehome.model.pettype.Type;
import com.onramp.android.takehome.model.pettype.Types;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PetDataManager {

    private static final String BASE_URL = "https://api.petfinder.com/";
    private String auth;
    private List<Type> types;

    private PetData petData;

    public PetDataManager(String auth) {
        //Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        petData = (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build())
                .create(PetData.class);


        this.auth = "Bearer " + auth;
    }

    public void getPetTypes(){
        Call<Types> call = petData.getPetTypes(auth);
        call.enqueue(new Callback<Types>() {
            @Override
            public void onResponse(Call<Types> call, Response<Types> response) {
                types = response.body().getTypes();
            }
            public void onFailure(Call<Types> call, Throwable t){
                Log.d("FAIL: ", "That call didn't work");
            }
        });
    }

    public List<Type> getTypes() {
        return types;
    }
}
