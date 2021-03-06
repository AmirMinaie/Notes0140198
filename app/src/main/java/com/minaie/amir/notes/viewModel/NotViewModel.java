package com.minaie.amir.notes.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.minaie.amir.notes.Repository.NoteRepository;
import com.minaie.amir.notes.model.Note;

import java.util.List;


public class NotViewModel extends AndroidViewModel {
private NoteRepository noteRepository;
private LiveData< List<Note>> allNote;

    public NotViewModel(@NonNull Application application) {
        super(application);
        noteRepository =new NoteRepository(application);
        allNote=noteRepository.getAllNote();
    }
    public  void insert(Note note){
        noteRepository.insert(note);
    }

    public  void update(Note note){
        noteRepository.update(note);
    }
    public  void delet(Note note){
        noteRepository.delete(note);
    }
    public LiveData< List<Note>> getAllNote(){
        return allNote;
    }
}
