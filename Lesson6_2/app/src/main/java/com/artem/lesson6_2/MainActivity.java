package com.artem.lesson6_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.artem.lesson6_2.pages.AboutFragment;
import com.artem.lesson6_2.pages.DoneNotesFragment;
import com.artem.lesson6_2.pages.ListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    DrawerLayout drawer;
    public static int needToUpdateRecView = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateListFragment();
        initNavigationDrawer();

    }

    private void initNavigationDrawer() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();
        menuSelect();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.notes);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void menuSelect() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
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


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (item.getItemId()) {
            case (R.id.notes):
                fragmentManager.beginTransaction()
                        .replace(R.id.list_container, new ListFragment(), null)
                        .addToBackStack(null)
                        .commit();

                break;


            case (R.id.notes_done):
                fragmentManager.beginTransaction()
                        .replace(R.id.list_container, new DoneNotesFragment(), null)
                        .addToBackStack(null)
                        .commit();
                break;

            case (R.id.about):
                fragmentManager.beginTransaction()
                        .replace(R.id.list_container, new AboutFragment(), null)
                        .addToBackStack(null)
                        .commit();
                break;

            case (R.id.nav_share):
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;

            case (R.id.nav_send):
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;


            default:
                return false;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}