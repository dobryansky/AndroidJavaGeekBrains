package com.artem.lesson6;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class DetailsFragment extends Fragment {
    private static final String ARG_INDEX = "index";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        LinearLayout layoutView = (LinearLayout) view;
        if (arguments != null) {
            int index = arguments.getInt(ARG_INDEX);
           TextView detailsText=new TextView(getContext());
            TextView date=new TextView(getContext());
            detailsText.setText(MainActivity.notes.get(index).getDescription());
            date.setText(MainActivity.notes.get(index).getDate().toString());
            layoutView.addView(detailsText);
            layoutView.addView(date);
        }

    }



    public static DetailsFragment newInstance(int index) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }
}