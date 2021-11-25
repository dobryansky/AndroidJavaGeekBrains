package com.artem.lesson6_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public final  class DataBaseNotes {
    private static DataBaseNotes instance;
    public static   ArrayList<Note> notes;

    private  DataBaseNotes(Note... note) {
        notes = new ArrayList<>();
       /* notes.add(new Note("скачать", "В панели инструментов «Разметка» коснитесь инструмента «Лассо»  (он находится между ластиком и линейкой)", new Date(), 5));
        notes.add(new Note("загрузить", "Коснитесь рисунка или рукописного текста и удерживайте, чтобы выбрать его, затем расширьте область выбора перетягиванием.", new Date(), 5));
        notes.add(new Note("выгрузить", "При необходимости скорректируйте область выбора, перетянув манипуляторы.", new Date(), 5));
        notes.add(new Note("выгрузить", "При необходимости скорректируйте область выбора, перетянув манипуляторы.", new Date(), 5));*/
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
