package async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import data.LabDatabase;
import entities.Person;

import android.os.AsyncTask;

import com.introtoandroid.csci490_lab_06_mattox.PersonsActivity;

public class AsyncTaskList extends AsyncTask<String, Void, Void> {

    private LabDatabase labDB;
    private List<Person> persons;
    private Context context;
    private ArrayList<String> personNames;

    public AsyncTaskList( LabDatabase labDB, Context context) {
        this.labDB = labDB;
        this.context = context;
        personNames = new ArrayList<>();
    }

    @Override
    protected Void doInBackground(String... strings) {

        persons = labDB.personDao().getAllPersons();
        for(Person p: persons) {
            personNames.add(p.getName());
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
    }
}
