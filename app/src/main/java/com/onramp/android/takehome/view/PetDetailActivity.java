package com.onramp.android.takehome.view;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.viewmodel.ServiceViewModel;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class PetDetailActivity extends AppCompatActivity {

    private ImageView ivPet;
    private TextView tvName, tvShortDescription, tvMeetMe, tvLongDescription;
    private Button btnPromise;
    private ServiceViewModel serviceViewModel;

    /**
     * Initialize and set View components
     * Unpack intent data
     * Set up onButtonClick listener to notify ViewModel to start Service
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_detail);


        ivPet = (ImageView) findViewById(R.id.ivPet);
        tvName = (TextView) findViewById(R.id.tvName);
        tvShortDescription = (TextView) findViewById(R.id.tvShortDescription);
        tvMeetMe = (TextView) findViewById(R.id.tvMeetMe);
        tvLongDescription = (TextView) findViewById(R.id.tvLongDescription);
        btnPromise = (Button) findViewById(R.id.btnPromise);

        //get intent extras
        //image
        String image = getIntent().getStringExtra("image");

        //name
        String name = getIntent().getStringExtra("name");


        //short description
        String size = getIntent().getStringExtra("size");
        size = formatSize(size);
        String gender = getIntent().getStringExtra("gender");
        gender = gender == "M" ? "Male" : "Female";
        String breed = getIntent().getStringExtra("breed");
        String age = getIntent().getStringExtra("age");

        //meet me


        //long description
        String longDesc = getIntent().getStringExtra("description");


        Picasso.get().load(image).into(ivPet);
        tvName.setText(name);
        tvShortDescription.setText(gender + " | " + breed + " | " + size + " | " + age);
        tvMeetMe.setText("Hi, I'm " + name + ". Nice to meet you!");
        tvLongDescription.setText(longDesc);

        this.requestPermissions(new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, 1);

        btnPromise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int check = ActivityCompat.checkSelfPermission(getApplicationContext(),android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (check == PackageManager.PERMISSION_GRANTED) {
                    serviceViewModel = new ServiceViewModel(getApplication());
                    serviceViewModel.initService();
                } else {
                    requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)) {
                    //Start your service here
                    serviceViewModel = new ServiceViewModel(getApplication());
                    serviceViewModel.initService();
                }
            }
        }
    }

    /**
     * Format the size variable for the UI
     * @param size
     * @return
     */
    public String formatSize(String size){
        switch(size){
            case "S":
                size = "Small";
                break;

            case "M":
                size = "Medium";
                break;

            case "L":
                size = "Large";
                break;

            case "XL":
                size = "Extra Large";
                break;
        }
        return size;
    }
}
