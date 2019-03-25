package com.onramp.android.takehome.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;

import com.onramp.android.takehome.model.PetTypes;

import java.util.List;

public class PetDataViewModel extends AndroidViewModel implements LifecycleObserver {

    public Application application;
    PetTypes pt;
    LiveData<List<String>> typeNames;

    public PetDataViewModel(@NonNull Application application) {
        super(application);

        this.application = application;
    }

    public LiveData<List<String>> getTypesList(){
        pt = new PetTypes(application);
        typeNames = pt.getPetTypeNames();

        return typeNames;
    }
}
