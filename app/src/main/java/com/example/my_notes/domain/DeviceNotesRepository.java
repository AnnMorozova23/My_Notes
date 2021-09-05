package com.example.my_notes.domain;

import com.example.my_notes.R;

import java.util.ArrayList;
import java.util.List;

public class DeviceNotesRepository implements NoteRepository {


    @Override
    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        notes.add(new Note(R.string.note_1));
        notes.add(new Note(R.string.note_2));
        notes.add(new Note(R.string.note_3));

        return notes;
    }
}
