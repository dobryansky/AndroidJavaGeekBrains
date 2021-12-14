package com.artem.lesson6_2.pages;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artem.lesson6_2.data.DataBaseNotes;
import com.artem.lesson6_2.MainActivity;
import com.artem.lesson6_2.adapters.NoteAdapter;
import com.artem.lesson6_2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListFragment extends Fragment {

    RecyclerView recycleView;
    FloatingActionButton btnAdd;
    NoteAdapter adapter;
    TextView textViewNonotes;
    DataBaseNotes dataBase = DataBaseNotes.getInstanse();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        DataBaseNotes dataBaseNotes = DataBaseNotes.getInstanse();
        super.onViewCreated(view, savedInstanceState);
        initRecycleView(view, dataBaseNotes);

    }

    private void initRecycleView(@NonNull View view, DataBaseNotes dataBaseNotes) {
        recycleView = view.findViewById(R.id.recView);
        adapter = new NoteAdapter(getContext(), dataBaseNotes);
        textViewNonotes = view.findViewById(R.id.text_no_notes);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(recycleView);
        if (MainActivity.needToUpdateRecView == 1) {
            adapter.notifyDataSetChanged();
        }
        recycleView.setAdapter(adapter);
        btnAdd = view.findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment addNoteFragment = new AddNoteFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.list_container, addNoteFragment)
                        .addToBackStack("list notes")
                        .commit();
            }
        });
        if (dataBaseNotes.getNotes().size() == 0) {
            textViewNonotes.setVisibility(View.VISIBLE);
        } else {
            textViewNonotes.setVisibility(View.GONE);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            dataBase.getNotes().remove(viewHolder.getAdapterPosition());
            adapter.notifyDataSetChanged();

        }
    };
}