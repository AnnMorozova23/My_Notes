package com.example.my_notes.ui.list;

import androidx.fragment.app.FragmentManager;

import com.example.my_notes.R;
import com.example.my_notes.domain.Note;
import com.example.my_notes.ui.detail.NoteDetailFragment;
import com.example.my_notes.ui.edit.EditNoteFragment;

public class Router {

    private final FragmentManager fragmentManager;

    public Router(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }


    public void showNotesList() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new NotesListFragment())
                .commit();

    }

    public void showInfo() {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, new InfoFragment())
                .commit();

    }

    public void showNotesDetails(Note note) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.container, NoteDetailFragment.newInstance(note))
                .addToBackStack(null)
                .commit();
    }

    public void showEditNote(Note note) {

        fragmentManager
                .beginTransaction()
                .replace(R.id.container, EditNoteFragment.newInstance(note))
                .addToBackStack(null)
                .commit();

    }
}
