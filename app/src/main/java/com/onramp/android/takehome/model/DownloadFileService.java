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

public class DownloadFileService extends IntentService {

    private int result = Activity.RESULT_CANCELED;
    public static final String URL = "https://d17fnq9dkz9hgj.cloudfront.net/uploads/2018/08/petfinder-pet-promise-certificate.pdf";

    public DownloadFileService() {
        super("DownloadFileService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        File output = new File(Environment.getExternalStorageDirectory(),
                "index.html");
        if (output.exists()) {
            output.delete();
        }

        InputStream stream = null;
        FileOutputStream fos = null;
        try {

            java.net.URL url = new URL(URL);
            stream = url.openConnection().getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            fos = new FileOutputStream(output.getPath());
            int next = -1;
            while ((next = reader.read()) != -1) {
                fos.write(next);
            }
            // successfully finished
            result = Activity.RESULT_OK;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        returnResults(output.getAbsolutePath(), result);
    }

    public void returnResults(String outputPath, int result){
        Intent intent = new Intent("download");
        intent.putExtra("path", outputPath);
        intent.putExtra("result", result);
        sendBroadcast(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


//    public int onStartCommand(Intent intent, int flags, int startId) {
        //return super.onStartCommand(intent, flags, startId);

//        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//
//        Uri downloadUri = Uri.parse("https://d17fnq9dkz9hgj.cloudfront.net/uploads/2018/08/petfinder-pet-promise-certificate.pdf");
//
//        DownloadManager.Request request = new DownloadManager.Request(downloadUri);
//        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
//        request.setAllowedOverRoaming(false);
//        request.setTitle("Downloading Pet Promise Certificate");
//        request.setDescription("Pet Promise Certificate");
//        request.setVisibleInDownloadsUi(true);
//        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Pet Promise Certificate");
//
//
//        downloadManager.enqueue(request);

//        Log.d("Testing", "TESTING SERVICE");

//        return START_STICKY;
//    }
}
