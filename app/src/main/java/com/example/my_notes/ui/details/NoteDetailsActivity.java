package com.example.my_notes.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.my_notes.R;
import com.example.my_notes.domain.Note;
import com.example.my_notes.ui.MainActivity;

public class NoteDetailsActivity extends AppCompatActivity {

    public static final String ARG_NOTE = "ARG_NOTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);


        if (getResources().getBoolean(R.bool.isLandscape)) {
            finish();
        } else {

            FragmentManager fragmentManager = getSupportFragmentManager();

            Note note = getIntent().getParcelableExtra(ARG_NOTE);

            fragmentManager.beginTransaction()
                    .replace(R.id.container, NoteDetailsFragment.newInstance(note), "NoteDetailsFragment")
                    .commit();
        }

    }
}