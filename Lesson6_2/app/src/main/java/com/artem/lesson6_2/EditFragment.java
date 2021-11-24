package com.artem.lesson6_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EditFragment extends Fragment {
    private Button btnSave;
    private int position;
    private EditText editNoteName, editDate, editDescription;

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
        editNoteName = view.findViewById(R.id.edit_note_name);
        editDescription = view.findViewById(R.id.edit_note_description);
        editDate = view.findViewById(R.id.edit_note_date);
        btnSave = view.findViewById(R.id.btn_save);
        editNoteName.setText(ListFragment.notes.get(position).getName());
        editDescription.setText(ListFragment.notes.get(position).getDescription());
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName=editNoteName.getText().toString();
                String newDescription=editDescription.getText().toString();
                ListFragment.notes.get(position).setName(newName);
                ListFragment.notes.get(position).setDescription(newDescription);
            }
        });

    }
}