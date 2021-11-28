package com.artem.lesson6_2;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.Calendar;


public class AddNoteFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    DataBaseNotes database = DataBaseNotes.getInstanse();
    TextView textDate;

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
        Button addButton = view.findViewById(R.id.btn_addNote);
        Button backButton = view.findViewById(R.id.btn_back);
        TextView editDate= view.findViewById(R.id.edit_date_datePicker);
         textDate= view.findViewById(R.id.text_add_date);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName=addName.getText().toString();
                String newDescription=addDescription.getText().toString();

                MainActivity.needToUpdateRecView=1;
               database.setNotes(new Note(newName,newDescription,textDate.getText().toString(),R.drawable.pic1));
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();


            }
        });

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePicker= new DatePickerFragment();
                datePicker.setTargetFragment(AddNoteFragment.this, 0);
                datePicker.show(getParentFragmentManager(),"date picker add");
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar calendar= Calendar.getInstance();
        calendar.set (Calendar.YEAR,year);
        calendar.set (Calendar.MONTH,month);
        calendar.set (Calendar.DAY_OF_MONTH,day);
        String currentDateString = DateFormat.getDateInstance().format(calendar.getTime());
        textDate.setText(currentDateString);
    }
}