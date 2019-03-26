package com.onramp.android.takehome.model;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.onramp.android.takehome.model.pets.PetObjects;
import com.onramp.android.takehome.model.pettype.Types;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class PetQuery {

    private Context context;
    private HashMap<String, String> searchParameters;

    //query file for data
    public PetQuery(Context context, HashMap<String, String> searchParameters){
        this.context = context;
        this.searchParameters = searchParameters;

        AssetManager assetManager = this.context.getAssets();
        InputStream input;
        String json = "";
        try {
            input = assetManager.open("petdata.json");

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            // byte buffer into a string
            json = new String(buffer);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PetObjects objects = new Gson().fromJson(json, PetObjects.class);

        Log.d("Test", "Test: " + objects.getObjects().get(0).getName());
        Log.d("Testing params: ", "yup: " + searchParameters.get("animal"));

    }

    void parsePets(){

    }
}
