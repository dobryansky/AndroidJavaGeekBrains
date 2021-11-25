package com.artem.lesson6_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;


public class EditFragment extends Fragment {
    private Button btnSave;
    private int position;
    private TextView editDate,textDate;
    private EditText editNoteName,  editDescription;
    DataBaseNotes database= DataBaseNotes.getInstanse();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt("position", 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yy MMMM yyyy, H:m:ss");
        editNoteName = view.findViewById(R.id.edit_note_name);
        editDescription = view.findViewById(R.id.edit_note_description);
        editDate = view.findViewById(R.id.edit_date);
        textDate = view.findViewById(R.id.text_date);
        btnSave = view.findViewById(R.id.btn_save);

        editNoteName.setText(database.getNotes().get(position).getName());
        editDescription.setText(database.getNotes().get(position).getDescription());
        textDate.setText(formatForDateNow.format(database.getNotes().get(position).getDate()));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName=editNoteName.getText().toString();
                String newDescription=editDescription.getText().toString();
                DataBaseNotes.notes.get(position).setName(newName);
                DataBaseNotes.notes.get(position).setDescription(newDescription);

            }
        });

    }
}