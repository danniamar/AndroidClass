package com.example.a64.listcontact.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.a64.listcontact.MainActivity;
import com.example.a64.listcontact.R;
import com.example.a64.listcontact.models.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 64 on 26/11/2016.
 */

public class Lista extends Fragment implements View.OnClickListener{
    private String [] ciudades = {"Bogotá", "Cali", "Medellin", "Pasto"};
    ArrayList<String> cities;
    ArrayAdapter<String> arrayAdapter;

    List<user> objUsuario =new ArrayList<user>();

    private RecyclerView mRecyclerView;
    private CustomRecyclerview mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_lista, container, false);

        cities = new ArrayList<String>(Arrays.asList(ciudades));

        objUsuario.add(new user("Dannia", "Ing. Sistemas", R.drawable.icon1));
        objUsuario.add(new user("Marisol", "Ing. Desarrollo", R.drawable.icon2));
        objUsuario.add(new user("Anna", "Comercial", R.drawable.icon3));

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new CustomRecyclerview(objUsuario);
        mRecyclerView.setAdapter(mAdapter);



        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Add:
                ((MainActivity)getActivity()).replaceFragment(new Formulario());
                break;
            default:
                break;
        }
    }
}
