package ua.antonzhuk.springmvcdemoapp.model;

import java.sql.Date;
import java.sql.Time;

public class Note {

    private int id;
    private String text;
    private java.sql.Date date;
    private Time time;

    public Note() {}

    public Note(int id, String text, java.sql.Date date, java.sql.Time time) {
        this(text);
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public Note(String text) {
        java.util.Date utilDate = new java.util.Date();
        date = new java.sql.Date(utilDate.getTime());
        time = new java.sql.Time(utilDate.getTime());
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
