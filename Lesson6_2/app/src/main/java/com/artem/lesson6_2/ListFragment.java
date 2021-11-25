package com.artem.lesson6_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class ListFragment extends Fragment {

    RecyclerView recycleView;
    FloatingActionButton btnAdd;
    NoteAdapter adapter;


    static ArrayList<Integer> images = new ArrayList<>(Arrays.asList(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic3));


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        DataBaseNotes dataBaseNotes= DataBaseNotes.getInstanse();
        super.onViewCreated(view, savedInstanceState);
        recycleView = view.findViewById(R.id.recView);
         adapter = new NoteAdapter(getContext(), dataBaseNotes, images);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        recycleView.setAdapter(adapter);
        btnAdd= view.findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment addNoteFragment =new AddNoteFragment();
                FragmentManager fragmentManager= getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.list_container,addNoteFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}