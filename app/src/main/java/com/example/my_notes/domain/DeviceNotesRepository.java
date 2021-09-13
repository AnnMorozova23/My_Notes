package com.example.my_notes.domain;

import com.example.my_notes.R;

import java.util.ArrayList;
import java.util.List;

public class DeviceNotesRepository implements NoteRepository {


    @Override
    public List<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        notes.add(new Note("id1", "Title 1", "https://https://images.freeimages.com/ru/photo/sunset-jungle-1383333"));
        notes.add(new Note("id2", "Title 2", "https://images.freeimages.com/images/large-previews/10f/autumn-1-1382513.jpg"));
        notes.add(new Note("id3", "Title 3", "https://https://images.freeimages.com/ru/photo/corcovado-sunset-1527899"));
        notes.add(new Note("id4", "Title 4", "https://images.freeimages.com/images/large-previews/476/chicago-night-traffic-1447010.jpg"));
        notes.add(new Note("id5", "Title 5", "https://images.freeimages.com/images/large-previews/89a/one-tree-hill-1360813.jpg"));

        return notes;
    }
}
