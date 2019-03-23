package com.onramp.android.takehome.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.onramp.android.takehome.model.pettype.Type;

import java.util.List;

public class AppViewModel extends ViewModel {

    LiveData<List<Type>> types;

    //expose animal type name list to view

    //expose breed, gender, and color to view


    //expose results of full api query to view


    //tell model which animal type was selected


    //tell model which parameters to query on

}
