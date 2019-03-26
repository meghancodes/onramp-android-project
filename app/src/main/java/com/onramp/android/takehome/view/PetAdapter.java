package com.onramp.android.takehome.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onramp.android.takehome.R;

import org.w3c.dom.Text;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    //get list of data from viewmodel
    public PetAdapter(@NonNull Context context) {
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPet;
        TextView tvName,tvDetails;

        public ViewHolder(View itemView, ){
            super(itemView);

            ivPet = itemView.findViewById(R.id.ivPet);
            tvName = itemView.findViewById(R.id.tvName);
            tvDetails = itemView.findViewById(R.id.tvDetails);

            //make entire row clickable
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }


    @NonNull
    @Override
    public PetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflating row layout
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.row_layout, viewGroup, false
        );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
