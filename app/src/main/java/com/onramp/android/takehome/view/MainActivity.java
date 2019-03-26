package com.onramp.android.takehome.view;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.pets.PetObject;
import com.onramp.android.takehome.viewmodel.PetDataViewModel;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerPet;
    private Spinner spinnerGender;
    private Spinner spinnerSize;
    private Spinner spinnerAge;
    private Button btnSearch;
    private ImageView ivFeaturedPet;
    private final PetDataViewModel petDataViewModel = new PetDataViewModel(getApplication());
    private String selectedPet;
    private String selectedGender;
    private String selectedSize;
    private String selectedAge;
    List<PetObject> petObjects;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final PetDataViewModel pd = new PetDataViewModel(getApplication());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //link variables to view components
        spinnerPet = (Spinner) findViewById(R.id.spinnerPet);
        spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
        spinnerSize = (Spinner) findViewById(R.id.spinnerSize);
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        ivFeaturedPet = (ImageView) findViewById(R.id.ivFeaturedPet);

        //initialize spinners
        initSpinners();

        //Collect search queries on button click
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedPet.equals("Select a pet")){
                    //A pet must be selected to search
                    Toast.makeText(MainActivity.this, "Select a pet to start!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    //Pass selected items to the viewmodel
                    //PetDataViewModel pd = new PetDataViewModel(getApplication());
                    //pd.onSearchButtonPressed(selectedPet, selectedGender, selectedSize, selectedAge);

                    if(pd.onSearchButtonPressed(selectedPet, selectedGender, selectedSize, selectedAge)){
                        //pass an intent with pd object to the next activity
                        Log.d("Here? ", "Result: true!");

                        pd.getPetObjects().observe(MainActivity.this, new Observer<List<PetObject>>() {
                            @Override
                            public void onChanged(@Nullable List<PetObject> petObjects) {
                                MainActivity.this.petObjects = petObjects;
                            }
                        });

                        //prep viewmodel instance to send
                        Gson gson = new Gson();
                        Type PetObjectType = new TypeToken<List<PetObject>>(){}.getType();

                        String petObjectsString = gson.toJson(petObjects, PetObjectType);

                        Intent i = new Intent(MainActivity.this, SearchResultsActivity.class);
                        i.putExtra("petObjectsString", petObjectsString);
                        startActivity(i);
                    }
                    else{
                        //no search results found
                        Snackbar.make(view, "Your search returned no results. Please try" +
                                " again.", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
            }
        });
    }


    public void initSpinners(){
        //SpinnerPet
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, petDataViewModel.exposePet());

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPet.setAdapter(adapter1);
        spinnerPet.setOnItemSelectedListener(this);


        //SpinnerGender
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, petDataViewModel.exposeGender());

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter2);
        spinnerGender.setOnItemSelectedListener(this);


        //SpinnerSize
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, petDataViewModel.exposeSize());

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSize.setAdapter(adapter3);
        spinnerSize.setOnItemSelectedListener(this);


        //SpinnerAge
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, petDataViewModel.exposeAge());

        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter4);
        spinnerAge.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int id = adapterView.getId();

        switch(id){
            case R.id.spinnerPet:
                selectedPet = adapterView.getItemAtPosition(i).toString();
                break;

            case R.id.spinnerGender:
                selectedGender = adapterView.getItemAtPosition(i).toString();
                break;

            case R.id.spinnerSize:
                selectedSize = adapterView.getItemAtPosition(i).toString();
                break;

            case R.id.spinnerAge:
                selectedAge = adapterView.getItemAtPosition(i).toString();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
