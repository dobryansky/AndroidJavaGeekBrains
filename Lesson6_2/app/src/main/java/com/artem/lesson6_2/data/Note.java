package com.artem.lesson6_2.data;

import android.widget.ImageView;

import java.util.Date;

public class Note {
    private String name;
    private String description;
    private String date;
    private ImageView imageView;
    private Boolean doneState;



    public Note(String name, String description, String date, ImageView imageView,Boolean doneState ) {
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

    public ImageView getImage() {
        return imageView;
    }

    public void setImage(ImageView imageView) {
        this.imageView = imageView;
    }

    public Boolean getDoneState() {
        return doneState;
    }

    public void setDoneState(Boolean doneState) {
        this.doneState = doneState;
    }
}
