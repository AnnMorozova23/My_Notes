package com.example.my_notes.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.my_notes.R;
import com.example.my_notes.domain.Note;
import com.example.my_notes.ui.details.NoteDetailsActivity;
import com.example.my_notes.ui.details.NoteDetailsFragment;
import com.example.my_notes.ui.list.NotesListFragment;

public class MainActivity extends AppCompatActivity implements NotesListFragment.onNoteOnClicked {

    private static final String ARG_NOTE = "ARG_NOTE";
    private Note selectedNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onNoteOnClicked(Note note) {
        selectedNote = note;

        if (note != null && getResources().getBoolean(R.bool.isLandscape)) {

        } else {
            Intent intent = new Intent(this, NoteDetailsActivity.class);
            intent.putExtra(NoteDetailsActivity.ARG_NOTE, note);
            startActivity(intent);
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        if (selectedNote != null) {
            outState.putParcelable(ARG_NOTE, selectedNote);
        }
        super.onSaveInstanceState(outState);
    }
}