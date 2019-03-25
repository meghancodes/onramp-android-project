package com.onramp.android.takehome.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.PetTypes;
import com.onramp.android.takehome.viewmodel.PetDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerPet;
    private Spinner spinnerBreed;
    private Spinner spinnerSex;
    private Spinner spinnerSize;
    private Spinner spinnerAge;
    private Spinner spinnerGoodWith;
    private Spinner spinnerSpecial;
    private EditText etZipCode;
    private Button btnSearch;
    private PetDataViewModel pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //link variables to view components
        spinnerPet = findViewById(R.id.spinnerPet);
        spinnerBreed = findViewById(R.id.spinnerBreed);
        spinnerSex = findViewById(R.id.spinnerSex);
        spinnerSize = findViewById(R.id.spinnerSize);
        spinnerAge = findViewById(R.id.spinnerAge);
        spinnerGoodWith = findViewById(R.id.spinnerGoodWith);
        spinnerSpecial = findViewById(R.id.spinnerSpecial);
        etZipCode = findViewById(R.id.etZipCode);
        btnSearch = findViewById(R.id.btnSearch);

        //hide spinners that won't be filled in upon init
        spinnerBreed.setVisibility(View.GONE);
        spinnerSex.setVisibility(View.GONE);
        spinnerSize.setVisibility(View.GONE);
        spinnerAge.setVisibility(View.GONE);
        spinnerGoodWith.setVisibility(View.GONE);
        spinnerSpecial.setVisibility(View.GONE);
        etZipCode.setVisibility(View.GONE);

        //populate spinner pet
        initSpinner();
        spinnerPet.setOnItemSelectedListener(this);



    }

    public void initSpinner(){
        //create new instance of viewmodel
        pd = ViewModelProviders.of(this).get(PetDataViewModel.class);
        getLifecycle().addObserver(pd);
        pd.getTypesList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                Log.d("Test", "Test");
            }
        });

        boolean bn = pd.getTypesList().hasActiveObservers();
        boolean obs = pd.getTypesList().hasObservers();
        List<String> typeNames = new ArrayList<>();
        typeNames = (List<String>) pd.getTypesList().getValue();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, typeNames);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPet.setAdapter(adapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        String selected = parent.getItemAtPosition(pos).toString();
        Log.d("Test", selected);


    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
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
