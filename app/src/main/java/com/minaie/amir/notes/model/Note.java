package com.minaie.amir.notes.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "note_table")
@TypeConverters({Converters.class})
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String head;

    private String dsc;

    private Date creatDate;

    private Date alartDate;

    private int priority;

    public Note(String head, String dsc, Date creatDate, Date alartDate, int priority) {
        this.head = head;
        this.dsc = dsc;
        this.creatDate = creatDate;
        this.alartDate = alartDate;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Date getAlartDate() {
        return alartDate;
    }

    public void setAlartDate(Date alartDate) {
        this.alartDate = alartDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
