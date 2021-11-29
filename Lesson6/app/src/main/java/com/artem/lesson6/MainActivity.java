package com.artem.lesson6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
 public static  ArrayList<Note> notes= new ArrayList<Note>(Arrays.asList(new Note("скачать","В панели инструментов «Разметка» коснитесь инструмента «Лассо»  (он находится между ластиком и линейкой)",new Date(),5),
                                                                        new Note("загрузить","Коснитесь рисунка или рукописного текста и удерживайте, чтобы выбрать его, затем расширьте область выбора перетягиванием.",new Date(),5),
         new Note("выгрузить","При необходимости скорректируйте область выбора, перетянув манипуляторы.",new Date(),5)));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // initNote();
        NoteFragment notefragment = new NoteFragment();
        DetailsFragment detailsFragment = new DetailsFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.notes, notefragment)
                .replace(R.id.details, detailsFragment)
                .commit();
    }

   /* private void initNote(){
        notes.add(new Note("скачать","В панели инструментов «Разметка» коснитесь инструмента «Лассо»  (он находится между ластиком и линейкой)",new Date(),5));
        notes.add(new Note("загрузить","Коснитесь рисунка или рукописного текста и удерживайте, чтобы выбрать его, затем расширьте область выбора перетягиванием.",new Date(),5));
        notes.add(new Note("выгрузить","При необходимости скорректируйте область выбора, перетянув манипуляторы.",new Date(),5));
    }*/
}