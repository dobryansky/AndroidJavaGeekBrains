package com.artem.lesson6_2.data;

import android.widget.ImageView;

public class NoteFireBase {
    private String name;
    private String description;
    private String date;
    private String imageView;
    private Boolean doneState;

    public NoteFireBase(String name, String description, String date, String imageView, Boolean doneState) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.imageView = imageView;
        this.doneState = doneState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }

    public Boolean getDoneState() {
        return doneState;
    }

    public void setDoneState(Boolean doneState) {
        this.doneState = doneState;
    }
}
