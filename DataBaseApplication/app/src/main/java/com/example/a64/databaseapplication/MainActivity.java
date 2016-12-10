package com.example.a64.databaseapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import static com.example.a64.databaseapplication.StudentDataBase.COLUMN_CARRER;
import static com.example.a64.databaseapplication.StudentDataBase.COLUMN_NAME;

public class MainActivity extends AppCompatActivity {
 private  Spinner spinner;
    private StudentDataBase studentDataBase;
    private ListView listView;
    private SimpleCursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner);
        String [] data = {"Ing. Sistemas","Ing. Mecanica","Ing. Electronica","Ing. Civil","Ing. Industrial"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));

        studentDataBase = new StudentDataBase(this);
        studentDataBase.openConnection();
        Cursor cursor = studentDataBase.getAll();
        cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor,
                new String[]{COLUMN_NAME, COLUMN_CARRER}, new int[]{android.R.id.text1,android.R.id.text2}, 1 );

        listView = (ListView) findViewById(R.id.lista);
        listView.setAdapter(cursorAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Cursor cursor =  studentDataBase.getByCarrer(parent.getItemAtPosition(position).toString());
                Log.e("carrera", parent.getItemAtPosition(position).toString());
                obtenerLista(cursor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void obtenerLista(Cursor cursor) {
        Log.e("cursor", " -- " +  cursor.getCount());
        cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor,
                new String[]{COLUMN_NAME, COLUMN_CARRER}, new int[]{android.R.id.text1,android.R.id.text2}, 1 );

        listView.setAdapter(cursorAdapter);
       // cursorAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
