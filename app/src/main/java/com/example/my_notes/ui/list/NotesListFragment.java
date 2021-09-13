package com.example.my_notes.ui.list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.my_notes.R;
import com.example.my_notes.domain.DeviceNotesRepository;
import com.example.my_notes.domain.Note;
import com.example.my_notes.ui.details.NoteDetailsActivity;

import java.util.Collections;
import java.util.List;

public class NotesListFragment extends Fragment implements NotesListView {

    private NoteAdapter adapter = new NoteAdapter();

    public interface onNoteOnClicked {
        void onNoteOnClicked(Note note);
    }

    public static final String KEY_SELECTED = "KEY_SELECTED";
    public static final String ARG_NOTE = "ARG_NOTE";

    private NoteListPresenter presenter;

    private onNoteOnClicked onNoteOnClicked;
    ImageView image = null;


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

        RecyclerView noteList = view.findViewById(R.id.notes_list);

        noteList.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        noteList.setAdapter(adapter);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_delete_all) {
                    adapter.setNotes(Collections.emptyList());
                    adapter.notifyDataSetChanged();
                    return true;
                }
                return false;
            }
        });

        presenter.requestNotes();


    }

    @Override
    public void showNotes(List<Note> notes) {

        adapter.setNotes(notes);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgress() {

    }
}
