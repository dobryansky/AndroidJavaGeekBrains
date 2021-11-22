package com.artem.lesson6_2;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
        holder.noteDate.setText(notes.get(position).getDate().toString());
        holder.img.setImageResource(images.get(position));
        holder.detailsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPortrait(view, position);

            }
        });

    }

    private void showPortrait(View view, int position) {
        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        Fragment detailFragment = new DetailsFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("position", position);
        detailFragment.setArguments(bundle);
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_container,detailFragment)
                .addToBackStack(null)
                .commit();
    }
    private void showLandscape(View view, int position) {
        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        Fragment detailFragment = new DetailsFragment();
        Bundle bundle=new Bundle();
        bundle.putInt("position", position);
        detailFragment.setArguments(bundle);
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_container,detailFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public int getItemCount() {
       return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder  {
        TextView noteName,noteDate;
        ImageView img;
        ConstraintLayout detailsLayout;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteName = itemView.findViewById(R.id.noteName);
            noteDate = itemView.findViewById(R.id.noteDate);
            img = itemView.findViewById(R.id.imageView);
            detailsLayout= itemView.findViewById(R.id.details_layout);
        }


    }

}
