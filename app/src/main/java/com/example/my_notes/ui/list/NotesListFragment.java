package com.example.my_notes.ui.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.my_notes.R;
import com.example.my_notes.domain.DeviceNotesRepository;
import com.example.my_notes.domain.Note;
import com.example.my_notes.ui.details.NoteDetailsActivity;

import java.util.List;

public class NotesListFragment extends Fragment implements NotesListView {

    public interface onNoteOnClicked {
        void onNoteOnClicked(Note note);
    }

    public static final String KEY_SELECTED = "KEY_SELECTED";
    public static final String ARG_NOTE = "ARG_NOTE";

    private NoteListPresenter presenter;

    private LinearLayout container;

    private onNoteOnClicked onNoteOnClicked;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof onNoteOnClicked) {
            onNoteOnClicked = (onNoteOnClicked) context;

        }
    }

    @Override
    public void onDetach() {
        onNoteOnClicked = null;
        super.onDetach();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new NoteListPresenter(this, new DeviceNotesRepository());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        container = view.findViewById(R.id.root);

        presenter.requestNotes();


    }

    @Override
    public void showNotes(List<Note> notes) {

        for (Note note : notes) {
            View noteItem = LayoutInflater.from(requireContext()).inflate(R.layout.item_notes, container, false);

            noteItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onNoteOnClicked != null) {
                        onNoteOnClicked.onNoteOnClicked(note);
                    }

                    Bundle bundle = new Bundle();
                    bundle.putParcelable(ARG_NOTE, note);
                    getParentFragmentManager().setFragmentResult(KEY_SELECTED, bundle);
                }
            });

            TextView noteName = noteItem.findViewById(R.id.note_name);
            noteName.setText(note.getName());

            container.addView(noteItem);

        }
    }
}
