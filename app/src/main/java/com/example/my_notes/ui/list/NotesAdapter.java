package com.example.my_notes.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.my_notes.R;
import com.example.my_notes.domain.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private final ArrayList<Note> data = new ArrayList<>();

    private OnNoteClickedListener listener;

    public OnNotelongClickedListener getLongClicklistener() {
        return LongClicklistener;
    }

    public void setLongClicklistener(OnNotelongClickedListener longClicklistener) {
        LongClicklistener = longClicklistener;
    }

    private OnNotelongClickedListener LongClicklistener;

    private Fragment fragment;

    public NotesAdapter(Fragment fragment){
        this.fragment = fragment;

    }

    public void setNotes(List<Note> toSet) {
        data.clear();
        data.addAll(toSet);
    }

    public void addNote(Note note) {
        data.add(note);

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note_list, parent, false);

        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.NotesViewHolder holder, int position) {
        Note note = data.get(position);

        holder.getTitle().setText(note.getTitle());

        Glide.with(holder.getImage()).load(note.getImageUrl()).
                centerCrop().into(holder.getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public OnNoteClickedListener getListener() {
        return listener;
    }

    public void setListener(OnNoteClickedListener listener) {
        this.listener = listener;
    }

    public int removeNote(Note selectedNote) {

        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).equals(selectedNote)){
                data.remove(i);
                return i;
            }

        }
        return -1;
    }

    public int updateNote(Note note) {
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).equals(note)){
                data.set(i, note);
                return i;
            }

        }
        return -1;
    }


    interface OnNoteClickedListener {
        void onNoteClicked(Note note);

    }

    interface OnNotelongClickedListener {
        void onNoteLongClicked(Note note);

    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;

        private final ImageView image;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            fragment.registerForContextMenu(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (getListener() != null) {
                        getListener().onNoteClicked(data.get(getAdapterPosition()));
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    itemView.showContextMenu();

                    if (getLongClicklistener()!= null) {
                        getLongClicklistener().onNoteLongClicked(data.get(getAdapterPosition()));
                    }
                    return true;
                }
            });

            title = itemView.findViewById(R.id.note_title);
            image = itemView.findViewById(R.id.note_image);
        }

        public TextView getTitle() {
            return title;
        }

        public ImageView getImage() {
            return image;
        }
    }
}