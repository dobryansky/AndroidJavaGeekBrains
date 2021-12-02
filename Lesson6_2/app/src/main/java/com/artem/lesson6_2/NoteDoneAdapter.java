package com.artem.lesson6_2;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteDoneAdapter extends RecyclerView.Adapter<NoteDoneAdapter.NoteViewHolder> {
    ArrayList<Note> notes;
    Context context;


    public NoteDoneAdapter(Context context, ArrayList<Note> notes) {
        this.notes = notes;
        this.context = context;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.noteName.setText(notes.get(position).getName());
        holder.noteDate.setText(notes.get(position).getDate());
        holder.noteImage.setImageDrawable(notes.get(position).getImage().getDrawable());
        holder.doneState.setChecked(notes.get(position).getDoneState());
        holder.detailsLayout.setBackground(context.getDrawable(R.drawable.outline_shape_green));
        holder.doneState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (holder.doneState.isChecked()) {
                    notes.get(holder.getAdapterPosition()).setDoneState(true);
                } else {
                    notes.get(holder.getAdapterPosition()).setDoneState(false);
                }
            }
        });
        holder.detailsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(view, holder.getAdapterPosition());
            }
        });

    }

    private void showFragment(View view, int position) {
        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        Fragment detailFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        detailFragment.setArguments(bundle);
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView noteName, noteDate;
        ImageView noteImage;
        CardView detailsLayout;
        CheckBox doneState;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteName = itemView.findViewById(R.id.noteName);
            noteDate = itemView.findViewById(R.id.noteDate);
            noteImage = itemView.findViewById(R.id.imageView_item);
            detailsLayout = itemView.findViewById(R.id.details_layout);
            doneState = itemView.findViewById(R.id.note_checkbox);

        }


    }


}
