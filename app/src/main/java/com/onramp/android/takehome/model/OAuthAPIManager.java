package com.onramp.android.takehome.model;

import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OAuthAPIManager {
    private static final String BASE_URL = "https://api.petfinder.com/";
    private static final String GRANT_TYPE = "client_credentials";
    private static final String CLIENT_ID = "CRLEc7mJAFo5HljMvcKBLwi7czWKE6FtroRjAZj78wCMWsNb5a";
    private static final String CLIENT_SECRET = "ReQfJuXwOxqt0n3C1Tv5BpfgWDVBPrOFgrTO5phS";

    private OAuthAPI oAuthAPI;

    public OAuthAPIManager(){
        oAuthAPI = (new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build())
                .create(OAuthAPI.class);
    }

    public void getToken(){

        Call<AccessToken> call = oAuthAPI.getAccessToken(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET );
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                /*Log.d("Token Type:", response.body().getTokenType());
                Log.d("Expires In: ", Integer.toString(response.body().getExpiresIn()));
                Log.d("Access Token:", response.body().getAccessToken());*/

                //Get Pet Types data
                PetDataManager petDataManager = new PetDataManager(response.body().getAccessToken());
                petDataManager.getPetTypes();
            }
            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Log.d("FAIL: ", "That call didn't work");
            }
        });

    }


}
