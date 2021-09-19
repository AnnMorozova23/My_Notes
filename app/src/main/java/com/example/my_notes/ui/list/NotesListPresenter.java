package com.example.my_notes.ui.list;


import android.view.View;

import com.example.my_notes.domain.Callback;
import com.example.my_notes.domain.Note;
import com.example.my_notes.domain.NotesRepository;

import java.util.List;

public class NotesListPresenter {

    private NotesListView view;

    private NotesRepository repository;

    public NotesListPresenter(NotesListView view, NotesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void requestNotes() {
        view.showProgress();

        repository.getNotes(new Callback<List<Note>>() {
            @Override
            public void onSuccess(List<Note> data) {
                view.showNotes(data);

                view.hideProgress();
            }
        });


    }

    public void addNote(String title, String imageUrl) {

        view.showProgress();

        repository.addNotes(title, imageUrl, new Callback<Note>() {
            @Override
            public void onSuccess(Note data) {
                view.onNoteAdded(data);

                view.hideProgress();

            }
        });
    }

    public void removeNote(Note selectedNote) {

        view.showProgress();

        repository.removeNotes(selectedNote, new Callback<Void>() {
            @Override
            public void onSuccess(Void data) {

                view.hideProgress();

                view.onNoteRemoved(selectedNote);

            }
        });


    }
}
