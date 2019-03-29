package com.onramp.android.takehome.model;

import android.Manifest;
import android.app.Application;
import android.content.Intent;

/**
 * Pass an intent to start the service
 */
public class ServiceManager {
    private Application application;
    private Intent serviceIntent;

    public ServiceManager(Application application){
        this.application = application;

        serviceIntent = new Intent(application, DownloadFileService.class);
        application.startService(serviceIntent);
    }

}

