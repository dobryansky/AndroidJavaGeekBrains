package com.artem.lesson6_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

BottomNavigationView bottomNavigationView;
    static int needToUpdateRecView=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateListFragment();
        menuSelect();


    }

    private void menuSelect() {
        bottomNavigationView= findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();

                switch (item.getItemId()) {
                    case (R.id.list_notes):
                        fragmentManager.beginTransaction()
                                .replace(R.id.list_container, new ListFragment(), null)
                                .addToBackStack(null)
                                .commit();

                        return true;


                    case (R.id.list_notes_done):
                        fragmentManager.beginTransaction()
                                .replace(R.id.list_container, new DoneNotesFragment(), null)
                                .addToBackStack(null)
                                .commit();
                        return true;

                    case (R.id.app_about):
                        fragmentManager.beginTransaction()
                                .replace(R.id.list_container, new AboutFragment(), null)
                                .addToBackStack(null)
                                .commit();
                        return true;


                    default:
                        return false;

                }
            }

        });
    }
    private void inflateListFragment() {
        ListFragment listFragment = new ListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
        fragmentManager.beginTransaction()
                .add(R.id.list_container, listFragment, null)
                .addToBackStack(null)
                .commit();
    }

}