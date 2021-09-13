package com.example.my_notes.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.my_notes.R;
import com.example.my_notes.domain.Note;

import java.util.ArrayList;
import java.util.List;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NotesViewHolder> {

    private final ArrayList<Note> data = new ArrayList();

    public void setNotes(List<Note> toSet) {
        data.clear();
        data.addAll(toSet);

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public NoteAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_list, parent, false);


        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NotesViewHolder holder, int position) {
        Note note = data.get(position);
        holder.getTitle().setText(note.getTitle());

        Glide.with(holder.getImage()).load(note.getImageUrl()).
                centerCrop().into(holder.getImage());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        public TextView getTitle() {
            return title;
        }

        public ImageView getImage() {
            return image;
        }

        private TextView title;

        private ImageView image;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.note_title);
            image = itemView.findViewById(R.id.note_image);


        }
    }
}
