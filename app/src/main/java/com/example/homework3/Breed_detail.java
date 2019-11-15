package com.example.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.homework3.Breed;
import com.example.homework3.fragments.FavRecyclerFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Breed_detail extends AppCompatActivity {
    private TextView name;
    private ImageView image;
    private TextView description;
    private TextView temperament;
    private TextView origin;
    private TextView life;
    private TextView link;
    private TextView dog;
    private TextView imperial;
    private TextView metric;
    private Button button;

    public static final String EXTRA_TEXT = "com.example.application.homework2.EXTRA_TEXT";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_detail);

        Intent intent = getIntent();
        String breedId = intent.getStringExtra("BreedID");

        Breed breed = Database.getBreedById(breedId);

        name = findViewById(R.id.name);
        image = findViewById(R.id.imageView);
        description = findViewById(R.id.description);
        imperial = findViewById(R.id.imperial);
        metric = findViewById(R.id.metric);
        temperament = findViewById(R.id.temp);
        origin = findViewById(R.id.origin);
        life = findViewById(R.id.life);
        link = findViewById(R.id.link);
        dog = findViewById(R.id.dog);


        name.setText(breed.getName());
//        image.setImageResource(breed.getImageDrawableId());
        description.setText(breed.getDescription());
        //imperial.setText();
        //metric.setText(Breed.Weight.getMetric());
        temperament.setText(breed.getTemperament());
        origin.setText(breed.getOrigin());
        life.setText(breed.getLife());
        link.setText(breed.getLink());
//        dog.setText(breed.getDog());


        Button addButton = findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                open();
            }
        });
    }

    public void open(){
        Intent intent = new Intent(getApplicationContext(), FavRecyclerFragment.class);

        TextView textName = findViewById(R.id.name);
        String name = textName.getText().toString();

        intent.putExtra(EXTRA_TEXT,name);

        startActivity(intent);
    }

}

