package com.example.my_notes.ui.list;


import com.example.my_notes.domain.Note;
import com.example.my_notes.domain.NoteRepository;

import java.util.List;

import javax.security.auth.callback.Callback;


public class NoteListPresenter {

    private final NotesListView view;

    private final NoteRepository repository;

    public NoteListPresenter(NotesListView view, NoteRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void requestNotes() {
        view.showProgress();

    }
}
