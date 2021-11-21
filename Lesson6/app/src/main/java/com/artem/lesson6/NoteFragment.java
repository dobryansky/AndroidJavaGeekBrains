package com.artem.lesson6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class NoteFragment extends Fragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;

        for (int i = 0; i < MainActivity.notes.size(); i++) {
            TextView tv = new TextView(getContext());
            tv.setText(MainActivity.notes.get(i).getName());
            tv.setTextSize(30);
            tv.setGravity(Gravity.CENTER);
            layoutView.addView(tv);
            final int position = i;
            tv.setOnClickListener(v -> {
                showNotes(position);
            });

        } {


        }
    }

    private void showNotes(int position) {
        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            showLandScapeNotes(position);
        } else {
            showPortraitNotes(position);
        }

    }

    private void showPortraitNotes(int index) {
        DetailsFragment detailsFragment = DetailsFragment.newInstance(index);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.notes, detailsFragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }

    private void showLandScapeNotes(int index) {
        DetailsFragment detailsFragment = DetailsFragment.newInstance(index);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.details, detailsFragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }


}