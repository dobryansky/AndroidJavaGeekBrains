package com.artem.lesson6_2.pages;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.artem.lesson6_2.data.DataBaseNotes;
import com.artem.lesson6_2.MainActivity;
import com.artem.lesson6_2.R;
import com.google.android.material.button.MaterialButton;


public class DetailsFragment extends Fragment {
    DataBaseNotes database= DataBaseNotes.getInstanse();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = 0;
        if (getArguments() != null) {
            position = this.getArguments().getInt("position", 0);
        }

        initViews(view, position);
    }

    private void initViews(@NonNull View view, int position) {

        FragmentManager fragmentManager = getParentFragmentManager();
        TextView noteDate = view.findViewById(R.id.noteDetailsDate);
        TextView noteName = view.findViewById(R.id.noteDetailsName);
        TextView noteDescription = view.findViewById(R.id.noteDetailsDescription);
        ImageView img = view.findViewById(R.id.imgDetails);
        noteDate.setText((database.notes.get(position).getDate()));
        noteName.setText(database.notes.get(position).getName());
        noteDescription.setText(database.notes.get(position).getDescription());
        img.setImageDrawable(database.notes.get(position).getImage().getDrawable());
        MaterialButton btnEdit = view.findViewById(R.id.btn_edit);
        MaterialButton btnDelete = view.findViewById(R.id.btn_delete_note);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditFragment editFragment = new EditFragment();
                Bundle setPosition = new Bundle();
                setPosition.putInt("position",position);
                editFragment.setArguments(setPosition);
                fragmentManager.beginTransaction()
                        .replace(R.id.list_container, editFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.getNotes().remove(position);
                MainActivity.needToUpdateRecView=1;
                fragmentManager.popBackStack();
            }
        });
    }
}