package com.example.homework3.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.homework3.Breed;
import com.example.homework3.CatBreedResponse;
import com.example.homework3.Database;
import com.example.homework3.MainActivity;
import com.google.gson.Gson;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.homework3.BreedAdapter;
import com.example.homework3.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class BreedRecyclerFragment extends Fragment {

    private RecyclerView recyclerView;

    public BreedRecyclerFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container,false);
        recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        final BreedAdapter breedAdapter = new BreedAdapter();
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String url = "https://api.thecatapi.com/v1/breeds";

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();


                //CatBreedResponse catBreedResponse = gson.fromJson(response, CatBreedResponse.class);
                Breed[] objectsArray = gson.fromJson(response, Breed[].class);

                List<Breed> objectList = Arrays.asList(objectsArray);

                breedAdapter.setData(objectList);
                Database.saveBreedsToFakeDatabase(objectList);
                recyclerView.setAdapter(breedAdapter);
                requestQueue.stop();

            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"The request failed: " + error.getMessage(),Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);
        requestQueue.add(stringRequest);

/*
        EditText editText = (EditText)getView(). findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
*/
        return view;
    }




    @Override
    public void onResume() {
        super.onResume();
        MainActivity parent = (MainActivity) getActivity();
        parent.showCoolMessage("cool (from ArticleRecyclerFragment onResume)");
    }


}