package com.artem.lesson6_2.adapters;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.artem.lesson6_2.R;

public  class NoteViewHolder extends RecyclerView.ViewHolder {
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