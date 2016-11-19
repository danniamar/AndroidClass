package com.example.a64.listviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener{
    private String [] ciudades = {"Bogotá", "Cali", "Medellin", "Pasto"};
    ArrayList<String> cities;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cities = new ArrayList<String>(Arrays.asList(ciudades));
        ListView listView = (ListView) findViewById(R.id.lista);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemLongClickListener(this);
    }

    public void agregarITEM(View view) {
        //Añadir items
        cities.add("Manizales");
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //eliminar item de la lista
        cities.remove(position);
        arrayAdapter.notifyDataSetChanged();
        return false;
    }
}
