package com.artem.lesson6_2.pages;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.artem.lesson6_2.data.DataBaseNotes;
import com.artem.lesson6_2.MainActivity;
import com.artem.lesson6_2.data.Note;
import com.artem.lesson6_2.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
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
        TextView editDate = view.findViewById(R.id.edit_date_datePicker);
        ImageView imageView = view.findViewById(R.id.image_add_note);
        Glide.with(getContext())
                .load("https://picsum.photos/100")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(imageView);
        textDate = view.findViewById(R.id.text_add_date);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName = addName.getText().toString();
                String newDescription = addDescription.getText().toString();
                String newDate = textDate.getText().toString();

                if (checkFields(newName, newDescription, newDate)) {
                    database.setNotes(new Note(newName, newDescription, newDate, imageView, false));
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    fragmentManager.popBackStack();
                    MainActivity.needToUpdateRecView = 1;
                }
            }


        });

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.setTargetFragment(AddNoteFragment.this, 0);
                datePicker.show(getParentFragmentManager(), "date picker add");
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
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        String currentDateString = DateFormat.getDateInstance().format(calendar.getTime());
        textDate.setText(currentDateString);
    }

    private boolean checkFields(String newName, String newDescription, String newDate) {
        if (newName.equals("") || newDescription.equals("") || newDate.equals("дата")) {
            showAlertDialog();
            return false;
        }
        return true;
    }

    private void showAlertDialog() {
        new AlertDialog.Builder(getActivity())
                .setTitle("ВНИМАНИЕ!")
                .setMessage("ЗАПОЛНИ ВСЕ ПОЛЯ!!!")
                // Можно указать и пиктограмму
                //.setIcon(R.mipmap.ic_launcher_round)
                // Из этого окна нельзя выйти кнопкой Back
                .setCancelable(false)
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })

                .show();
    }

}