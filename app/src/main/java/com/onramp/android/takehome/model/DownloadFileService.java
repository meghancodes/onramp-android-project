package com.onramp.android.takehome.model;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class DownloadFileService extends IntentService {

    private long downloadID;

    public DownloadFileService() {
        super("DownloadFileService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Use a background thread to run service - download the Pet Promise Certificate
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        File file=new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS), "");
        /*
        Create a DownloadManager.Request with all the information necessary to start the download
         */
        DownloadManager.Request request=new DownloadManager.Request(Uri.parse("https://d17fnq9dkz9hgj.cloudfront.net/uploads/2018/08/petfinder-pet-promise-certificate.pdf"))
                .setTitle("Dummy File")// Title of the Download Notification
                .setDescription("Downloading")// Description of the Download Notification
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)// Visibility of the download Notification
                .setDestinationUri(Uri.fromFile(file))// Uri of the destination file
                .setRequiresCharging(false)// Set if charging is required to begin the download
                .setAllowedOverMetered(true)// Set if download is allowed on Mobile network
                .setAllowedOverRoaming(true);// Set if download is allowed on roaming network
        DownloadManager downloadManager= (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        downloadID = downloadManager.enqueue(request);// enqueue puts the download request in the queue.
    }
}
