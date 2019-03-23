package com.onramp.android.takehome.model;

import com.onramp.android.takehome.model.pettype.Types;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface PetData {

    //Get All Pet Types
    @GET("v2/types")
    Call<Types> getPetTypes(@Header("Authorization") String authorization);



}
