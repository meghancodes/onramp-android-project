package com.onramp.android.takehome.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.onramp.android.takehome.R;

public class SearchResultsActivity extends AppCompatActivity implements PetAdapter.ItemClicked {

    FragmentManager fragmentManager;
    Fragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        //get a link to the fragment
        fragmentManager = getSupportFragmentManager();
        listFragment = fragmentManager.findFragmentById(R.id.listFragment);
    }

    @Override
    public void onItemClicked(int index) {
        //pass the clicked item to the next activity
    }
}
