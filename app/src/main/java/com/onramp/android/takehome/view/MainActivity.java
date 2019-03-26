package com.onramp.android.takehome.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.APIManager;
import com.onramp.android.takehome.viewmodel.PetDataViewModel;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerPet;
    private Spinner spinnerGender;
    private Spinner spinnerSize;
    private Spinner spinnerAge;
    private Button btnSearch;
    private PetDataViewModel petDataViewModel = new PetDataViewModel(getApplication());

    private String selectedPet;
    private String selectedGender;
    private String selectedSize;
    private String selectedAge;


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

        //APIManager apiManager = new APIManager();
        //apiManager.getResults("Dog");

        //link variables to view components
        spinnerPet = (Spinner) findViewById(R.id.spinnerPet);
        spinnerGender = (Spinner) findViewById(R.id.spinnerGender);
        spinnerSize = (Spinner) findViewById(R.id.spinnerSize);
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        btnSearch = (Button) findViewById(R.id.btnSearch);

        //initialize spinners
        initSpinners();

        //Collect search queries
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedPet.equals("Select a pet")){
                    //A pet must be selected to search
                    Toast.makeText(MainActivity.this, "Select a pet to start!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    PetDataViewModel pd = new PetDataViewModel(getApplication());
                    pd.onSearchButtonPressed(selectedPet, selectedGender, selectedSize, selectedAge);
                }
            }
        });

    }

//    public void initSpinner(){
//        //create new instance of viewmodel
//        pd = ViewModelProviders.of(this).get(PetDataViewModel.class);
//        getLifecycle().addObserver(pd);
//        pd.getTypesList().observe(this, new Observer<List<String>>() {
//            @Override
//            public void onChanged(@Nullable List<String> strings) {
//                Log.d("Test", "Test");
//            }
//        });
//
//        boolean bn = pd.getTypesList().hasActiveObservers();
//        boolean obs = pd.getTypesList().hasObservers();
//        List<String> typeNames = new ArrayList<>();
//        typeNames = (List<String>) pd.getTypesList().getValue();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
//                        android.R.layout.simple_spinner_item, typeNames);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerPet.setAdapter(adapter);
//    }

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
