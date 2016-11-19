package com.example.a64.listviewapplication;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by 64 on 19/11/2016.
 */

public class ListaActividad extends ListActivity {
    private String [] ciudades = {"Bogotá", "Cali", "Medellin", "Pasto"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ciudades);
        setListAdapter(arrayAdapter);
    }
}
