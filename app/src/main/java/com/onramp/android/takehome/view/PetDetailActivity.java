package com.onramp.android.takehome.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onramp.android.takehome.R;

import org.w3c.dom.Text;

public class PetDetailActivity extends AppCompatActivity {

    ImageView ivPet;
    TextView tvName, tvShortDescription, tvMeetMe, tvLongDescription, tvDetails;
    Button btnAdopt;

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

        //get intent extras
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

        //additional details

        tvName.setText(name);
        tvShortDescription.setText(gender + " | " + breed + " | " + size + " | " + age);
        tvMeetMe.setText("Hi, I'm " + name + ". Nice to meet you!");
        tvLongDescription.setText(longDesc);




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
