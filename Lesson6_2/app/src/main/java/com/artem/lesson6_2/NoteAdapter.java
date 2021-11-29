package com.artem.lesson6_2;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    ArrayList<Note> notes;
    ArrayList<Integer> images;
    Context context;

    public NoteAdapter(Context context, ArrayList<Note> notes, ArrayList<Integer> images ) {
        this.notes = notes;
        this.images = images;
        this.context = context;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.item_note,parent,false);
        return new NoteViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.noteName.setText(notes.get(position).getName());
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd");
        holder.noteDate.setText(formatForDateNow.format(notes.get(position).getDate()));
        holder.detailsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showFragment(view, position);

            }
        });

    }

    private void showFragment(View view, int position) {
        AppCompatActivity activity = (AppCompatActivity) view.getContext();

        if (activity.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            Fragment detailFragment = new DetailsFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("position", position);
            detailFragment.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container,detailFragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            Fragment detailFragment = new DetailsFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("position", position);
            detailFragment.setArguments(bundle);
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.list_container,detailFragment)
                    .addToBackStack(null)
                    .commit();

        }



    }


    @Override
    public int getItemCount() {
       return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder  {
        TextView noteName,noteDate;

        LinearLayout detailsLayout;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteName = itemView.findViewById(R.id.noteName);
            noteDate = itemView.findViewById(R.id.noteDate);
            detailsLayout= itemView.findViewById(R.id.details_layout);
        }


    }


}
