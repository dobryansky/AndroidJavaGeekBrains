package com.artem.lesson6_2;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class DetailsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       assert getArguments() != null;
        int position = getArguments().getInt("position");
        TextView noteDate = view.findViewById(R.id.noteDetailsDate);
        TextView noteName = view.findViewById(R.id.noteDetailsName);
        TextView noteDescription = view.findViewById(R.id.noteDetailsDescription);
        ImageView img = view.findViewById(R.id.imgDetails);
        noteDate.setText(ListFragment.notes.get(position).getDate().toString());
        noteName.setText(ListFragment.notes.get(position).getName());
        noteDescription.setText(ListFragment.notes.get(position).getDescription());
        img.setImageResource(ListFragment.images.get(position));
    }
}