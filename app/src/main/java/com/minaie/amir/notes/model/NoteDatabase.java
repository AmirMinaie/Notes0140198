package com.minaie.amir.notes.model;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Date;

@Database(entities = {Note.class}, version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instanse;
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instanse == null) {
            instanse = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instanse;
    }

    public abstract NoteDao noteDao();

    private static class PopulatedDbe extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        public PopulatedDbe(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("h 1", "d 1", new Date(),new Date(), 1));

            noteDao.insert(new Note("h2", "d2", new Date(), new Date(),2));
            noteDao.insert(new Note("h3", "d3", new Date(),new Date(), 3));
            return null;
        }
    }
}
