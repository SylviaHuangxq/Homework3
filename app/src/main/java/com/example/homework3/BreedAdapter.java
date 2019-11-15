package com.example.homework3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BreedAdapter extends RecyclerView.Adapter<BreedAdapter.BreedViewHolder> {
    private List<Breed> breedToAdapt;

    public void setData(List<Breed> breedToAdapt) {
        this.breedToAdapt = breedToAdapt;
    }

    @NonNull
    @Override
    public BreedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.breed,parent,false);
        BreedViewHolder breedViewHolder = new BreedViewHolder(view);
        return breedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BreedViewHolder holder, int position) {
        final Breed breedAtPosition = breedToAdapt.get(position);

        holder.name.setText(breedAtPosition.getName());

        holder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Context context = view.getContext();

                Intent intent = new Intent(view.getContext(), Breed_detail.class);
                intent.putExtra("BreedID", breedAtPosition.getBreedID());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return breedToAdapt.size();
    }

    public static class BreedViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView name;
        public ImageView image;
        public TextView description;
        public TextView imperial;
        public TextView metric;
        public TextView temperament;
        public TextView origin;
        public TextView life;
        public TextView link;
        public TextView dog;

        public BreedViewHolder(View v) {
            super(v);
            view = v;
            name = v.findViewById(R.id.name);
            image = v.findViewById(R.id.image);
            description = v.findViewById(R.id.description);
            imperial = v.findViewById(R.id.imperial);
          //  metric = v.findViewById(R.id.metric);
           // temperament = v.findViewById(R.id.temp);
            origin = v.findViewById(R.id.origin);
            life = v.findViewById(R.id.life);
            link = v.findViewById(R.id.link);
            dog = v.findViewById(R.id.dog);

        }

    }

}
