package com.onramp.android.takehome.model;

import com.google.gson.annotations.SerializedName;

public class AccessToken {
    @SerializedName("token_type")
    private String tokenType;
    @SerializedName("expires_in")
    private int expiresIn;
    @SerializedName("access_token")
    private String accessToken;


    public AccessToken(String tokenType, int expiresIn, String accessToken){
        this.tokenType = tokenType;
        this.expiresIn = expiresIn;
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }


}
