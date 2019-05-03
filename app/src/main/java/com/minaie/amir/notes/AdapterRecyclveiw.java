package com.minaie.amir.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.minaie.amir.notes.model.Note;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdapterRecyclveiw extends RecyclerView.Adapter<AdapterRecyclveiw.ViewHolder> {
    private List<Note> Notes;
    private Context context;

    public AdapterRecyclveiw(List<Note> notes, Context context) {
        Notes = notes;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = Notes.get(position);
        holder.Head.setText(note.getHead());
        holder.Dsc.setText(note.getDsc());
        holder.Date.setText(new SimpleDateFormat("yy/MM/dd").format( note.getCreatDate()));
        holder.Time.setText(new SimpleDateFormat("HH:MM").format( note.getCreatDate()));
    }

    @Override
    public int getItemCount() {
        return Notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Head;
        public TextView Dsc;
        public TextView Date;
        public TextView Time;

        public ViewHolder(View itemView) {
            super(itemView);
            Head = (TextView) itemView.findViewById(R.id.texthead);
            Dsc = (TextView) itemView.findViewById(R.id.textdsc);
            Date = (TextView) itemView.findViewById(R.id.Date);
            Time= (TextView) itemView.findViewById(R.id.timeCrete);
        }
    }
}
