package com.onramp.android.takehome.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.pets.PetObject;
import com.onramp.android.takehome.viewmodel.PetDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity implements PetAdapter.ItemClicked {

    public FragmentManager fragmentManager;
    public Fragment listFragment;
    public List<PetObject> petObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        //get a link to the fragment
        fragmentManager = getSupportFragmentManager();
        listFragment = fragmentManager.findFragmentById(R.id.listFragment);

        //get passed viewmodel instance
        Gson gson = new Gson();
        String petObjectsString = getIntent().getStringExtra("petObjectsString");
        petObjects = gson.fromJson(petObjectsString, ArrayList.class);

        fragmentManager.beginTransaction()
                .show(listFragment)
                .commit();

    }

    @Override
    public void onItemClicked(int index) {
        //pass the clicked item to the next activity
    }
}
