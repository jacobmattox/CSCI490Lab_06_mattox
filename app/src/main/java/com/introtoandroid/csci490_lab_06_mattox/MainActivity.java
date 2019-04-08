package com.introtoandroid.csci490_lab_06_mattox;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import async.AsyncTaskList;
import async.AsyncTaskSubmit;
import data.LabDatabase;
import entities.Person;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button submit;
    private Button list;
    private LabDatabase labDB;
    private String DATABASE_NAME;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        submit = findViewById(R.id.submit);
        list = findViewById(R.id.list);
        DATABASE_NAME = "Test";
        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME).build();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString() != "") {
                    name = editText.getText().toString();
                    Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Person person = new Person();
                            person.setName(name);
                            labDB.personDao().insertPerson(person);
                        }
                    }).start();
                }
            }
        });
        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "list works", Toast.LENGTH_SHORT).show();
                AsyncTaskList asyncTaskList = new AsyncTaskList(labDB, getApplicationContext());
                asyncTaskList.execute();

            }
        });

    }

}
