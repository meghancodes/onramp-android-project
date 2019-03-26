package com.onramp.android.takehome.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.pets.PetObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    RecyclerView recyclerView; //refers to recyclerview
    RecyclerView.Adapter myAdapter; //refers to carAdapter class
    RecyclerView.LayoutManager layoutManager; //linear or gridlayout
    View view; //refers to row_layout

    SearchResultsActivity sra = new SearchResultsActivity();

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = view.findViewById(R.id.fragment_list);
        recyclerView.setHasFixedSize(true); //for better performance

        layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new PetAdapter(this.getActivity(), ((SearchResultsActivity)this.getActivity()).petObjects); //pass list of data as second param
        recyclerView.setAdapter(myAdapter);
    }
}
