package com.onramp.android.takehome.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.onramp.android.takehome.model.ServiceManager;

public class ServiceViewModel extends AndroidViewModel {
    ServiceManager serviceManager;
    Application application;

    public ServiceViewModel(Application application){
        super(application);

        this.application = application;
    }

    /**
     * Start the service
     */
    public void initService(){
        serviceManager = new ServiceManager(application);
    }


    /**
     * Set up download results item to be observed by PetDetailActivity
     * @return
     */
    public LiveData<Boolean> getDownloadResult() { return serviceManager.success; }
}
