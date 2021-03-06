package com.onramp.android.takehome.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onramp.android.takehome.R;
import com.onramp.android.takehome.model.pets.PetObject;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    ItemClicked activity;

    private List<PetObject> pets;

    public interface ItemClicked {
        void onItemClicked(int index);
    }


    public PetAdapter(@NonNull Context context, List<PetObject> list) {
        activity = (ItemClicked) context;
        this.pets = list;
    }

    /**
     * Custom ViewHolder class that instantiates row_layout items
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPet;
        TextView tvName,tvDetails;

        public ViewHolder(View itemView){
            super(itemView);

            ivPet = itemView.findViewById(R.id.ivPet);
            tvName = itemView.findViewById(R.id.tvName);
            tvDetails = itemView.findViewById(R.id.tvDetails);

            //make entire row clickable
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.onItemClicked(pets.indexOf((PetObject) view.getTag()));
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

    //set UI data for each pet returned
    @Override
    public void onBindViewHolder(@NonNull PetAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(pets.get(i));

        viewHolder.tvName.setText(this.pets.get(i).getName());
        viewHolder.tvDetails.setText(pets.get(i).getBreed());

        //put in the background
        //must be an https*
        //String url = processImages(pets.get(i).getAllImages());
        //String url = "https://i.ytimg.com/vi/28uUsJ72a1A/hqdefault.jpg";
        Picasso.get().load(pets.get(i).getImageUrl()).into(viewHolder.ivPet);


    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public String processImages(String allImages){
        List<String> images = Arrays.asList(allImages.split("\\s*,\\s*"));

        return images.get(0);
    }
}
