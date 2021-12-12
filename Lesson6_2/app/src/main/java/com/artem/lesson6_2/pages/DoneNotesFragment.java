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
import android.widget.TextView;

import java.util.ArrayList;


public class DoneNotesFragment extends Fragment {

    RecyclerView recycleViewDone;
    ArrayList<Note> doneNote= new ArrayList<Note>();
    NoteDoneAdapter adapter;
    TextView textViewNonotes;
    DataBaseNotes dataBase = DataBaseNotes.getInstanse();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_done_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        doneNote=getDoneNotes(dataBase);
        recycleViewDone = view.findViewById(R.id.recViewDone);
        adapter = new NoteDoneAdapter(getContext(), doneNote);
        textViewNonotes = view.findViewById(R.id.text_no_done);
        recycleViewDone.setLayoutManager(new LinearLayoutManager(getContext()));
       /* if (MainActivity.needToUpdateRecView == 1) {
            adapter.notifyDataSetChanged();
        }*/
        recycleViewDone.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        if (doneNote.size() == 0) {
            textViewNonotes.setVisibility(View.VISIBLE);
        } else {
            textViewNonotes.setVisibility(View.GONE);
        }
    }

    private ArrayList<Note> getDoneNotes(DataBaseNotes dataBase){
        ArrayList<Note> doneNotes= new ArrayList<>();
        for (int i = 0; i < dataBase.getNotes().size(); i++) {

            if(dataBase.getNotes().get(i).getDoneState()){
                doneNotes.add(dataBase.getNotes().get(i));
            }
        }
        return doneNotes;
    }


}