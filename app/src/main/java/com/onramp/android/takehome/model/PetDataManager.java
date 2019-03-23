package com.onramp.android.takehome.model;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.onramp.android.takehome.model.pettype.Type;
import com.onramp.android.takehome.model.pettype.Types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PetDataManager {

    private static final String BASE_URL = "https://api.petfinder.com/";
    private String auth;
    Types types;
    private OAuthAPIManager oAuthAPIManager;
    //public MutableLiveData<List<String>> petTypeNames = new MutableLiveData<>();

    private PetData petData;

    public PetDataManager() {

        oAuthAPIManager = new OAuthAPIManager();
        oAuthAPIManager.getToken();
        //auth = "Bearer " + oAuthAPIManager.returnToken();

        petData = (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build())
                .create(PetData.class);
    }

    public void getPetTypes(){
        Call<Types> call = petData.getPetTypes(auth);
        call.enqueue(new Callback<Types>() {
            @Override
            public void onResponse(Call<Types> call, Response<Types> response) {
                types = response.body();
            }
            public void onFailure(Call<Types> call, Throwable t){
                Log.d("FAIL: ", "That call didn't work");
            }
        });
    }

    public List<String> getPetTypeNames(){
        getPetTypes();

        List<String> typeNames = new ArrayList<>(types.getTypes().size());

        for (int i = 0; i < types.getTypes().size(); i++){
            typeNames.add(types.getTypes().get(i).getName());
        }

        return typeNames;
    }
}
