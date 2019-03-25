package com.onramp.android.takehome.view;

import android.os.Bundle;
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
import android.widget.Spinner;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.viewmodel.PetDataViewModel;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerPet;
    private Spinner spinnerGender;
    private Spinner spinnerSize;
    private Spinner spinnerAge;
    private Button btnSearch;
    private PetDataViewModel petDataViewModel = new PetDataViewModel(getApplication());
    private String selectedPetType;

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
        spinnerGender = findViewById(R.id.spinnerGender);
        spinnerSize = findViewById(R.id.spinnerSize);
        spinnerAge = findViewById(R.id.spinnerAge);
        btnSearch = findViewById(R.id.btnSearch);


        //initialize spinners
        initSpinners();



        //Send data to search
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                Log.d("In spinner pet? ", "Yes");
                break;
        }
        selectedPetType = adapterView.getItemAtPosition(i).toString();
        Log.d("Test: ", selectedPetType);
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
