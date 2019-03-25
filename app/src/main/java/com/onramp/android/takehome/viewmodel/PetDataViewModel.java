package com.onramp.android.takehome.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.onramp.android.takehome.model.PetTypes;

import java.util.ArrayList;
import java.util.List;

public class PetDataViewModel extends AndroidViewModel implements LifecycleObserver {

    public Application application;
    //PetTypes pt;
    LiveData<List<String>> typeNames;

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

    public List<String> exposePet(){
        List<String> pet = new ArrayList<>();
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
        gender.add("Male");
        gender.add("Female");

        return gender;
    }

    public List<String> exposeSize(){
        List<String> size = new ArrayList<>();
        size.add("S");
        size.add("M");
        size.add("L");
        size.add("XL");

        return size;
    }

    public List<String> exposeAge(){
        List<String> age = new ArrayList<>();
        age.add("Baby");
        age.add("Young");
        age.add("Adult");
        age.add("Senior");

        return age;
    }

}
