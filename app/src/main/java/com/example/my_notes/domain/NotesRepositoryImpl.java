package com.example.my_notes.domain;


import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotesRepositoryImpl implements NotesRepository {

    public static final NotesRepository INSTANCE = new NotesRepositoryImpl();

    private Handler handler = new Handler(Looper.getMainLooper());

    ArrayList<Note> res = new ArrayList<>();

    public NotesRepositoryImpl() {
        res.add(new Note("id1", "Title 1", "https://images.freeimages.com/images/large-previews/241/night-fog-1521028.jpg"));
        res.add(new Note("id2", "Title 2", "https://images.freeimages.com/images/large-previews/10f/autumn-1-1382513.jpg"));
        res.add(new Note("id3", "Title 3", "https://images.freeimages.com/images/large-previews/bfd/clouds-1371838.jpg"));
        res.add(new Note("id4", "Title 4", "https://images.freeimages.com/images/large-previews/476/chicago-night-traffic-1447010.jpg"));
        res.add(new Note("id5", "Title 5", "https://images.freeimages.com/images/large-previews/89a/one-tree-hill-1360813.jpg"));
    }

    @Override
    public void getNotes(Callback<List<Note>> callback) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(res);
                    }
                });
            }
        }).start();
    }

    @Override
    public void addNotes(String title, String image, Callback<Note> callback) {


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Note result = new Note(UUID.randomUUID().toString(), title, image);
                res.add(result);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(result);
                    }
                });
            }
        }).start();


    }

    @Override
    public void removeNotes(Note note, Callback<Void> callback) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                res.remove(note);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(null);
                    }
                });
            }
        }).start();


    }
}
