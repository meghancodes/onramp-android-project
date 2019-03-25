package com.onramp.android.takehome.model;

import com.onramp.android.takehome.model.pets.PetObjects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ConnectPetsAPI {

    @GET("page/{page}")
    Call<PetObjects> getPets(@Path(":pg") String pageNum, @Query("animal") String animal);
}
