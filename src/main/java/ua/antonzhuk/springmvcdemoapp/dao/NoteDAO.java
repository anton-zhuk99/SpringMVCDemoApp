package ua.antonzhuk.springmvcdemoapp.dao;

import ua.antonzhuk.springmvcdemoapp.model.Note;

import java.util.List;

public interface NoteDAO {

    void save(Note note);

    void update(Note note);

    void delete(int noteId);

    Note get(int noteId);

    List<Note> list();

}
