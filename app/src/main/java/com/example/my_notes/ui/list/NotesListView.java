package com.example.my_notes.ui.list;

import com.example.my_notes.domain.Note;

import java.util.List;

public interface NotesListView {

    void showNotes(List<Note> notes);

    void hideProgress();

    void showProgress();
}
