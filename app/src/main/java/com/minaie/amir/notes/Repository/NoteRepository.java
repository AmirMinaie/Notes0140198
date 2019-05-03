package com.minaie.amir.notes.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.minaie.amir.notes.model.Note;
import com.minaie.amir.notes.model.NoteDao;
import com.minaie.amir.notes.model.NoteDatabase;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData< List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNote();
    }

    public void insert(Note note) {
        new InsertNotAsyncTask(noteDao).execute(note);
    }

    public void update(Note note) {
        new UpdateNotAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeletNotAsyncTask(noteDao).execute(note);
    }

    public LiveData< List<Note>> getAllNote() {
        return noteDao.getAllNote();
    }

    public List<Note> getAllNoteAlert() {
        return noteDao.getAllNoteAlert();
    }

    private static class InsertNotAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private InsertNotAsyncTask(NoteDao notedoe) {
            this.noteDao = notedoe;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }


    }

    private static class DeletNotAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private DeletNotAsyncTask(NoteDao notedoe) {
            this.noteDao = notedoe;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }


    }

    private static class UpdateNotAsyncTask extends AsyncTask<Note, Void, Void> {
        private NoteDao noteDao;

        private UpdateNotAsyncTask(NoteDao notedoe) {
            this.noteDao = notedoe;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }


    }


}
