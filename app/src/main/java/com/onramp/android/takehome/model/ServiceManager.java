package com.onramp.android.takehome.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/**
 * Pass an intent to start the service
 */
public class ServiceManager {
    private Application application;
    private Intent serviceIntent;
    BroadcastReceiver broadcastReceiver;
    public MutableLiveData<Boolean> success = new MutableLiveData<>();

    public ServiceManager(Application application){
        this.application = application;

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //Log.d("TESTING: ", "Broadcast received!!!");
               success.postValue(true);

                closeReceiver();


            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("Download Complete");
        application.registerReceiver(broadcastReceiver, intentFilter);

        //start service
        serviceIntent = new Intent(application, DownloadFileService.class);
        application.startService(serviceIntent);
        //success.postValue();
    }

    public void closeReceiver(){
        application.unregisterReceiver(broadcastReceiver);
    }


}



