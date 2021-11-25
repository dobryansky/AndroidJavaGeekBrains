package com.artem.lesson6_2;

import java.util.Date;

public class Note {
    private String name;
    private String description;
    private String date;
    int image;




    public Note(String name, String description, String date, int image) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
