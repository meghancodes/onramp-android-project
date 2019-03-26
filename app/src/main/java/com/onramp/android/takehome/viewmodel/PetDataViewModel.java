package com.onramp.android.takehome.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.NonNull;

import com.onramp.android.takehome.model.PetQuery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetDataViewModel extends AndroidViewModel implements LifecycleObserver {

    public Application application;
    private HashMap<String, String> searchParams;
    PetQuery petQuery;
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


    public boolean onSearchButtonPressed(String pet, String gender, String size, String age){
        HashMap<String, String> searchParams = new HashMap<>();

        searchParams.put("animal", pet);

        if(!gender.equals("Select a gender")){
            gender = gender.substring(0,1).toUpperCase();
            searchParams.put("sex", gender);
        }
        if(!size.equals("Select a size")){
            size = formatXL(size);
            searchParams.put("size", size);
        }
        if(!age.equals("Select an age")){
            searchParams.put("age", age);
        }

        this.searchParams = searchParams;

        //begin pet search
        petQuery = new PetQuery(application, searchParams);
        petQuery.parse();

        return true;
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
        size.add("Extra Large");

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

    public String formatXL(String size){
        if(size.equals("Extra Large")){
            size = "XL";
        }
        else{
            size = size.substring(0,1).toUpperCase();
        }

        return size;
    }

}
