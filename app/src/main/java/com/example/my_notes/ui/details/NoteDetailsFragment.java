package com.example.my_notes.ui.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.my_notes.R;
import com.example.my_notes.domain.Note;
import com.example.my_notes.ui.list.NotesListFragment;

public class NoteDetailsFragment extends Fragment {

    private static final String ARG_NOTE = "ARG_NOTE";

    public static NoteDetailsFragment newInstance(Note note) {
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle argument = new Bundle();

        argument.putParcelable(ARG_NOTE, note);

        fragment.setArguments(argument);

        return fragment;
    }

    public NoteDetailsFragment() {

        super(R.layout.fragment_notes_details);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.search){
            Toast.makeText(requireContext(), "Search", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(item.getItemId() == R.id.action_settings){
            Toast.makeText(requireContext(), "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private TextView noteName;
    private EditText description;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        noteName = view.findViewById(R.id.note_name);

        description = view.findViewById(R.id.description_1);

        getParentFragmentManager().setFragmentResultListener(NotesListFragment.KEY_SELECTED, getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                Note note = result.getParcelable(NotesListFragment.ARG_NOTE);
                displayNote(note);
            }
        });

        if (getArguments() != null && getArguments().containsKey(ARG_NOTE)) {

            Note note = getArguments().getParcelable(ARG_NOTE);

            if (note != null) {
                displayNote(note);
            }

        }
    }

    private void displayNote(Note note) {
        noteName.setText(note.getTitle());

    }
}
