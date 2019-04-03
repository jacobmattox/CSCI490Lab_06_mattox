package data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import entities.Person;


@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}

