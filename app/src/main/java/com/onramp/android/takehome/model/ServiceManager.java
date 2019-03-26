package com.onramp.android.takehome.model;

import android.app.Application;
import android.content.Intent;

public class ServiceManager {
    private Application application;
    private Intent serviceIntent;

    public ServiceManager(Application application){
        this.application = application;

        serviceIntent = new Intent(application, DownloadFileService.class);
        application.startService(serviceIntent);
    }


}
