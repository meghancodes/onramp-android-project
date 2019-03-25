package com.onramp.android.takehome.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.onramp.android.takehome.model.PetTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetDataViewModel extends AndroidViewModel implements LifecycleObserver {

    public Application application;
    private HashMap<String, String> searchParams;
    //PetTypes pt;
    //LiveData<List<String>> typeNames;

    public PetDataViewModel(@NonNull Application application) {
        super(application);

        this.application = application;
        //pt = new PetTypes(application);
    }

//    public LiveData<List<String>> getTypesList(){
//        typeNames = pt.getPetTypeNames();
//
//        return typeNames;
//    }

    public void submitSearchParams(HashMap<String, String> searchParams){
        this.searchParams = searchParams;

        Log.d("Search params: ", "First: " + searchParams.get("animal"));
        Log.d("Search params: ", "2nd: " + searchParams.get("sex"));
        Log.d("Search params: ", "3rd: " + searchParams.get("age"));
    }


    public List<String> exposePet(){
        List<String> pet = new ArrayList<>();
        pet.add("Select a pet");
        pet.add("Dog");
        pet.add("Cat");
        pet.add("Rabbit");
        pet.add("Bird");
        pet.add("Horse");
        pet.add("Barnyard");

        return pet;
    }

    public List<String> exposeGender(){
        List<String> gender = new ArrayList<>();
        gender.add("Select a gender");
        gender.add("Male");
        gender.add("Female");

        return gender;
    }

    public List<String> exposeSize(){
        List<String> size = new ArrayList<>();
        size.add("Select a size");
        size.add("Small");
        size.add("Medium");
        size.add("Large");
        size.add("Extra large");

        return size;
    }

    public List<String> exposeAge(){
        List<String> age = new ArrayList<>();
        age.add("Select an age");
        age.add("Baby");
        age.add("Young");
        age.add("Adult");
        age.add("Senior");

        return age;
    }

}
