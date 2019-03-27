package com.onramp.android.takehome.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

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
}
