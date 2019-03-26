package com.onramp.android.takehome.model;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.onramp.android.takehome.model.pets.PetObject;
import com.onramp.android.takehome.model.pets.PetObjects;
import com.onramp.android.takehome.model.pettype.Types;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetQuery {

    private Context context;
    private HashMap<String, String> searchParameters;
    PetObjects petObjects;
    List<PetObject> resultPets = new ArrayList<>();

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

        petObjects = new Gson().fromJson(json, PetObjects.class);

    }

    public void parse(){
        parseAnimal();

        if(searchParameters.containsKey("gender")){
            parseGender();
        }
        if(searchParameters.containsKey("size")){
            parseSize();
        }
        if(searchParameters.containsKey("age")){
            parseAge();
        }

    }

    public void parseAnimal(){
        for(int i = 0; i < petObjects.getObjects().size(); i++){
            if(petObjects.getObjects().get(i).getAnimal().equals(searchParameters.get("animal"))){
                resultPets.add(petObjects.getObjects().get(i));
            }
        }
    }

    public boolean parseGender(){
        if(resultPets.size() > 0){
            for(int i = 0; i < resultPets.size(); i++){
                if(!resultPets.get(i).getSex().equals(searchParameters.get("gender"))){
                    resultPets.remove(i);
                }
            }
        }
        else{
            return false;
        }

        return true;
    }

    public boolean parseSize(){
        if(resultPets.size() > 0){
            for(int i = 0; i < resultPets.size(); i++){
                if(!resultPets.get(i).getSize().equals(searchParameters.get("size"))){
                    resultPets.remove(i);
                }
            }
        }
        else{
            return false;
        }

        return true;
    }

    public boolean parseAge(){
        if(resultPets.size() > 0){
            for(int i = 0; i < resultPets.size(); i++){
                if(!resultPets.get(i).getAge().equals(searchParameters.get("age"))){
                    resultPets.remove(i);
                }
            }
        }
        else{
            return false;
        }

        return true;
    }
}
