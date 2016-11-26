package com.example.a64.listviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    private RecyclerView mRecyclerView;
    private CustomRecyclerview mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cities = new ArrayList<String>(Arrays.asList(ciudades));
        ListView listView = (ListView) findViewById(R.id.lista);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities);
        CustomArrayAdapter arrayAdapter = new CustomArrayAdapter (this, cities);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemLongClickListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CustomRecyclerview(cities);
        mRecyclerView.setAdapter(mAdapter);

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
