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
    PetTypes pt;
    LiveData<List<String>> typeNames;

    public PetDataViewModel(@NonNull Application application) {
        super(application);

        this.application = application;
        pt = new PetTypes(application);
    }

    public LiveData<List<String>> getTypesList(){
        typeNames = pt.getPetTypeNames();

        return typeNames;
    }

    public List<String> exposeSex(){
        List<String> sex = new ArrayList<>();
        sex.add("Male");
        sex.add("Female");

        return sex;
    }

    public List<String> exposeSize(){
        List<String> size = new ArrayList<>();
        size.add("Male");
        size.add("Female");

        return size;
    }

    public List<String> exposeAge(){
        List<String> age = new ArrayList<>();
        age.add("Male");
        age.add("Female");

        return age;
    }

    public List<String> exposeGoodWith(){
        List<String> goodWith = new ArrayList<>();
        goodWith.add("Male");
        goodWith.add("Female");

        return goodWith;
    }

    public List<String> exposeSpecial(){
        List<String> special = new ArrayList<>();
        special.add("Male");
        special.add("Female");

        return special;
    }
}
