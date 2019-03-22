package com.onramp.android.takehome.model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface OAuthAPI {
    @FormUrlEncoded
    @POST("v2/oauth2/token")
    Call<AccessToken> getAccessToken(@Field("grant_type")String grantType,
                                     @Field("client_id") String clientId,
                                     @Field("client_secret") String clientSecret);
}
