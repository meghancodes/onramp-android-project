package com.onramp.android.takehome.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.pets.PetObject;
import com.onramp.android.takehome.viewmodel.PetDataViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsActivity extends AppCompatActivity implements PetAdapter.ItemClicked {

    public FragmentManager fragmentManager;
    public Fragment listFragment;
    public List<PetObject> petObjects;

    /**
     * Obtain results data from MainActivity
     * Show the fragment
     * @param savedInstanceState
     */
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

        Type PetObjectType = new TypeToken<List<PetObject>>(){}.getType();

        petObjects = gson.fromJson(petObjectsString, PetObjectType);

        fragmentManager.beginTransaction()
                .show(listFragment)
                .commit();

    }

    /**
     * Pass the clicked pet's data to PetDetailActivity and start Activity
     * @param index
     */
    @Override
    public void onItemClicked(int index) {
        //pass the clicked item to the next activity
        Intent i = new Intent(this, PetDetailActivity.class);
        i.putExtra("name", petObjects.get(index).getName());
        i.putExtra("gender", petObjects.get(index).getSex());
        i.putExtra("size", petObjects.get(index).getSize());
        i.putExtra("age", petObjects.get(index).getAge());
        i.putExtra("description", petObjects.get(index).getDescription());
        i.putExtra("breed", petObjects.get(index).getBreed());
        i.putExtra("image", petObjects.get(index).getImageUrl());
        startActivity(i);
    }
}
