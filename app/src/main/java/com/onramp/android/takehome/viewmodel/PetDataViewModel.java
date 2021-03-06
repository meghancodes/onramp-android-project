package com.onramp.android.takehome.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.onramp.android.takehome.model.PetQuery;
import com.onramp.android.takehome.model.pets.PetObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PetDataViewModel extends AndroidViewModel implements LifecycleObserver {

    public Application application;
    private HashMap<String, String> searchParams;
    PetQuery petQuery;

    public PetDataViewModel(@NonNull Application application) {
        super(application);

        this.application = application;
    }

    /**
     * Send user search parameters to the Model
     * @param pet
     * @param gender
     * @param size
     * @param age
     * @return
     */
    public boolean onSearchButtonPressed(String pet, String gender, String size, String age){
        HashMap<String, String> searchParams = new HashMap<>();

        searchParams.put("animal", pet);

        if(!gender.equals("Select a gender")){
            gender = gender.substring(0,1).toUpperCase();
            searchParams.put("sex", gender);
        }
        if(!size.equals("Select a size")){
            size = formatSize(size);
            searchParams.put("size", size);
        }
        if(!age.equals("Select an age")){
            searchParams.put("age", age);
        }

        this.searchParams = searchParams;

        //begin pet search
        petQuery = new PetQuery(application, searchParams);

        return petQuery.parse();
    }

    /**
     * Set up results item to be observed by MainActivity
     * @return
     */
    public LiveData<List<PetObject>> getPetObjects(){
        return petQuery.results;
    }

    /**
     * Expose pet options for the spinner
     * @return
     */
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

    /**
     * Expose gender options for the spinner
     * @return
     */
    public List<String> exposeGender(){
        List<String> gender = new ArrayList<>();
        gender.add("Select a gender");
        gender.add("Male");
        gender.add("Female");

        return gender;
    }

    /**
     * Expose size options for the spinner
     * @return
     */
    public List<String> exposeSize(){
        List<String> size = new ArrayList<>();
        size.add("Select a size");
        size.add("Small");
        size.add("Medium");
        size.add("Large");
        size.add("Extra Large");

        return size;
    }

    /**
     * Expose age options for the spinner
     * @return
     */
    public List<String> exposeAge(){
        List<String> age = new ArrayList<>();
        age.add("Select an age");
        age.add("Baby");
        age.add("Young");
        age.add("Adult");
        age.add("Senior");

        return age;
    }

    /**
     * Format the size
     * @param size
     * @return
     */
    public String formatSize(String size){
        if(size.equals("Extra Large")){
            size = "XL";
        }
        else{
            size = size.substring(0,1).toUpperCase();
        }

        return size;
    }

}
