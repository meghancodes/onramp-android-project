package com.onramp.android.takehome.model;

import com.onramp.android.takehome.model.pets.PetObjects;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ConnectPetsAPI {

    @POST("pet/page/1")
    Call<PetObjects> getPets(@Query("animal") String animal);
}
