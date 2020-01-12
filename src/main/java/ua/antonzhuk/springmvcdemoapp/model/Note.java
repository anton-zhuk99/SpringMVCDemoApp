package ua.antonzhuk.springmvcdemoapp.model;

public class Note {

    private int id;
    private String text;

    public Note() {}

    public Note(int id, String text) {
        this(text);
        this.id = id;
    }

    public Note(String text) {
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
}
