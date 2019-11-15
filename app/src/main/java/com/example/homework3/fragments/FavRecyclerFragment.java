package com.example.homework3.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework3.Breed_detail;
import com.example.homework3.R;

public class FavRecyclerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_fav, container, false);

        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra(Breed_detail.EXTRA_TEXT);

        TextView textViewName = RootView.findViewById(R.id.name);

        textViewName.setText(name);

        return RootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        //MainActivity parent = (MainActivity) getActivity();

    }
}
