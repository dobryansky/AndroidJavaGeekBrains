package com.artem.lesson6_2;

import android.widget.ImageView;

import java.util.Date;

public class Note {
    private String name;
    private String description;
    private String date;
    ImageView imageView;




    public Note(String name, String description, String date, ImageView imageView) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.imageView = imageView;
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
}
