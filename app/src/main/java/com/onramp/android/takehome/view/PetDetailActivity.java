package com.onramp.android.takehome.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.viewmodel.ServiceViewModel;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class PetDetailActivity extends AppCompatActivity {

    private ImageView ivPet;
    private TextView tvName, tvShortDescription, tvMeetMe, tvLongDescription, tvDetails;
    private Button btnAdopt, btnPromise;
    private ServiceViewModel serviceViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_detail);

        ivPet = (ImageView) findViewById(R.id.ivPet);
        tvName = (TextView) findViewById(R.id.tvName);
        tvShortDescription = (TextView) findViewById(R.id.tvShortDescription);
        tvMeetMe = (TextView) findViewById(R.id.tvMeetMe);
        tvLongDescription = (TextView) findViewById(R.id.tvLongDescription);
        tvDetails = (TextView) findViewById(R.id.tvDetails);
        btnAdopt = (Button) findViewById(R.id.btnAdopt);
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

        btnPromise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test", "IN PROMISE BUTTON");
                serviceViewModel = new ServiceViewModel(getApplication());
                serviceViewModel.initService();

            }
        });

        btnAdopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Test", "IN ADOPT BUTTON");
            }
        });


    }

    public void onPromiseButtonClick(){

    }

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
