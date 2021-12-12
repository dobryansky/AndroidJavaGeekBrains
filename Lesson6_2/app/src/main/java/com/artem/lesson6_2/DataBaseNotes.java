package com.artem.lesson6_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public final  class DataBaseNotes {
    private static DataBaseNotes instance;
    public static   ArrayList<Note> notes;

    private  DataBaseNotes(Note... note) {
        notes = new ArrayList<>();
        notes.addAll(Arrays.asList(note));
    }

    public  void setNotes(Note... note) {
        notes.addAll(Arrays.asList(note));
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public static DataBaseNotes getInstanse() {
        if (instance == null) {
            instance = new DataBaseNotes();
        }
        return instance;
    }
}
