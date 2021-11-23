package com.artem.lesson6_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            if (getResources().getConfiguration().orientation
                    == Configuration.ORIENTATION_LANDSCAPE) {
                ListFragment listFragment= new ListFragment();
                DetailsFragment detailsFragment= new DetailsFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.list_container, listFragment,null)
                        .add(R.id.detail_container,detailsFragment,null)
                        .addToBackStack(null)
                        .commit();
            } else {
                ListFragment listFragment= new ListFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.list_container, listFragment,null)
                        .addToBackStack(null)
                        .commit();
            }



    }

}