package com.onramp.android.takehome.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.onramp.android.takehome.model.OAuthAPI;
import com.onramp.android.takehome.model.OAuthAPIManager;
import com.onramp.android.takehome.model.PetDataManager;
import com.onramp.android.takehome.model.pettype.Type;

import java.util.List;

public class AppViewModel extends AndroidViewModel {

    //LiveData<List<String>> petTypesObservable;
    private OAuthAPIManager oAuthAPIManager;
    private PetDataManager petDataManager;
    private String accessToken;
    //private String authorization;

    public AppViewModel(Application application){
        super(application);
        /*Create an instance of AuthAPIManager
        * Get access token
        * Set authorization*/

        //authorization = "Bearer " + accessToken;
    }


    //expose animal type name list to view
    public List<String> getPetTypeNames(){
        petDataManager = new PetDataManager();
        return petDataManager.getPetTypeNames();
    }

    //expose breed, gender, and color to view


    //expose results of full api query to view


    //tell model which animal type was selected


    //tell model which parameters to query on

}
