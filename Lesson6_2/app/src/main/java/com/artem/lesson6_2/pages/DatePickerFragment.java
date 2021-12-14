package com.artem.lesson6_2.pages;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;


public class DatePickerFragment extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int year= calendar.get(Calendar.YEAR);
        int month= calendar.get(Calendar.MONTH);
        int day= calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener) getTargetFragment() ,year, month, day );
    }
}