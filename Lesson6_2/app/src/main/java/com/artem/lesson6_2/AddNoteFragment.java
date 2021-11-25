package com.artem.lesson6_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;


public class AddNoteFragment extends Fragment {

    DataBaseNotes database = DataBaseNotes.getInstanse();
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextInputEditText addName = view.findViewById(R.id.add_note_name);
        TextInputEditText addDescription = view.findViewById(R.id.add_note_description);
        DatePicker datePicker = view.findViewById(R.id.addDate);
        Button addButton = view.findViewById(R.id.btn_addNote);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName=addName.getText().toString();
                String newDescription=addDescription.getText().toString();
                StringBuilder newDate= new StringBuilder();
                addDescription.setText(newDate
                        // Месяц отсчитывается с 0, поэтому добавляем 1
                        .append(datePicker.getDayOfMonth()).append(".")
                        .append(datePicker.getMonth() + 1).append(".")
                        .append(datePicker.getYear()));

                database.setNotes(new Note(newName,newDescription,newDate.toString(),R.drawable.pic1));








            }
        });
    }


}