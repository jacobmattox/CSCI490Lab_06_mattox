package async;

import android.os.AsyncTask;

import java.util.ArrayList;

import entities.Person;

public class AsyncTaskList extends AsyncTask<Void, Void, ArrayList<Person>> {

    public AsyncTaskList() {
    }

    @Override
    protected ArrayList<Person> doInBackground(Void... voids) {
        return null;
    }
}
