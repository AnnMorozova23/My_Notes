package com.example.my_notes.domain;


import java.util.List;

public interface NotesRepository {

    void getNotes(Callback<List<Note>> callback);

    void addNotes(String title, String image, Callback<Note> callback);

    void removeNotes(Note note, Callback<Void> callback);

}
