package com.artem.lesson6_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class ListFragment extends Fragment {

    RecyclerView recycleView;
    static ArrayList<Note> notes = new ArrayList<>(Arrays.asList(new Note("скачать", "В панели инструментов «Разметка» коснитесь инструмента «Лассо»  (он находится между ластиком и линейкой)", new Date(), 5),
            new Note("загрузить", "Коснитесь рисунка или рукописного текста и удерживайте, чтобы выбрать его, затем расширьте область выбора перетягиванием.", new Date(), 5),
            new Note("выгрузить", "При необходимости скорректируйте область выбора, перетянув манипуляторы.", new Date(), 5)));


    static ArrayList<Integer> images = new ArrayList<>(Arrays.asList(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3));


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleView = view.findViewById(R.id.recView);
        NoteAdapter adapter = new NoteAdapter(getContext(), notes, images);
        recycleView.setAdapter(adapter);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}