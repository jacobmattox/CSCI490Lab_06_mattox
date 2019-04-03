package data;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import entities.Person;

public interface PersonDao {

    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();
}
