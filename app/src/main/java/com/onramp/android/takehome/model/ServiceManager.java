package com.onramp.android.takehome.model;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.onramp.android.takehome.view.MainActivity;

import static android.app.Activity.RESULT_OK;

public class ServiceManager {
    private Application application;
    private Intent serviceIntent;

    public ServiceManager(Application application){
        this.application = application;

        serviceIntent = new Intent(application, DownloadFileService.class);
        application.startService(serviceIntent);
    }

    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String string = bundle.getString("path");
            int resultCode = bundle.getInt("result");
            if (resultCode == RESULT_OK) {
                Log.d("File downloaded", "Downloaded!!");
            } else {
                Log.d("File not downloaded", "NO :(");
            }
        }
    }
}

