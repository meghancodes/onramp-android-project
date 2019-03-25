package com.onramp.android.takehome.model;

import android.app.Application;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.onramp.android.takehome.model.pettype.Types;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PetTypes extends Application implements LifecycleObserver {

    private Types types;
    private Context context;
    public MutableLiveData<List<String>> Names;


    public PetTypes(Context context) {
        this.context = context;
        loadPetTypes();
    }


    public void loadPetTypes() {
        AssetManager assetManager = context.getAssets();
        InputStream input;
        String json = "";
        try {
            input = assetManager.open("pettypes.json");

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

        Types types = new Gson().fromJson(json, Types.class);

        setTypes(types);
    }

    public LiveData<List<String>> getPetTypeNames(){
        if(Names == null){
            Names = new MutableLiveData<>();

            List<String> typeNames = new ArrayList<>(types.getTypes().size());

            for(int i = 0; i < types.getTypes().size(); i++){
                typeNames.add(types.getTypes().get(i).getName());
            }

            Names.setValue(typeNames);
        }


        return Names;
    }

    public List<String> getPetColors(String pet){
        List<String> petColors = new ArrayList<>();

        for(int i = 0; i < types.getTypes().size(); i++){
            if(types.getTypes().get(i).getName().equals(pet)){
                petColors = types.getTypes().get(i).getColors();
            }
        }
        return petColors;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }
}
